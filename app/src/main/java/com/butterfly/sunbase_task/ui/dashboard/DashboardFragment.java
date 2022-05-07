package com.butterfly.sunbase_task.ui.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.butterfly.sunbase_task.Adapter.SearchAdapter;
import com.butterfly.sunbase_task.Model.SearchModel.SearchModel;
import com.butterfly.sunbase_task.R;
import com.butterfly.sunbase_task.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    View view;
    RecyclerView rcv_search;
    SearchAdapter searchAdapter;
    EditText et_search_query;
    List<SearchModel> models = new ArrayList<>();
    Integer page = 1;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=  inflater.inflate(R.layout.fragment_dashboard, container, false);
        rcv_search=view.findViewById(R.id.rcv_search);
        et_search_query= view.findViewById(R.id.et_search_query);

        rcv_search.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false));
        DashboardViewModel model1= ViewModelProviders.of(this).get(DashboardViewModel.class);

        model1.getSearchdata(et_search_query.getText().toString(), "1").observe(getActivity(), new Observer<SearchModel>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(SearchModel homeModels) {
                if (page == 1) {
                    searchAdapter = new SearchAdapter(getContext(), homeModels.getResults());
                    rcv_search.setAdapter(searchAdapter);
                } else  {
                    searchAdapter.notifyDataSetChanged();
                }
            }
        });

        et_search_query.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                model1.loadSearchData(s.toString(), "1");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        rcv_search.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    page = page + 1;
                    model1.loadSearchData(et_search_query.getText().toString(), page.toString());
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}