package com.butterfly.sunbase_task.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.butterfly.sunbase_task.Adapter.HomeAdapter;
import com.butterfly.sunbase_task.Model.HomeModel.HomeModel;
import com.butterfly.sunbase_task.R;

import java.util.List;

public class HomeFragment extends Fragment {

    HomeAdapter adapter;
    View view;
    RecyclerView rcv_home;
    List<HomeModel> homeModels;
    HomeAdapter homeAdapter;
    private NestedScrollView nestedSV;

    int page = 0, limit = 10;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=  inflater.inflate(R.layout.fragment_home, container, false);
        rcv_home=view.findViewById(R.id.rcv_home);
        rcv_home.setHasFixedSize(true);
        rcv_home.setLayoutManager(new LinearLayoutManager(getContext()));

        rcv_home.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false));

        HomeViewModel model1=ViewModelProviders.of(this).get(HomeViewModel.class);
        model1.getHomesData().observe(getActivity(), new Observer<List<HomeModel>>() {
            @Override
            public void onChanged(List<HomeModel> homeModels) {
                adapter = new HomeAdapter(getContext(), homeModels);
                rcv_home.setAdapter(adapter);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}