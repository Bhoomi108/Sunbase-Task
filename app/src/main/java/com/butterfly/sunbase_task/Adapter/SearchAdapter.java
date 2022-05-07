package com.butterfly.sunbase_task.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.butterfly.sunbase_task.Model.SearchModel.ResultsItem;
import com.butterfly.sunbase_task.Model.SearchModel.SearchModel;
import com.butterfly.sunbase_task.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    Context context;
    List<ResultsItem> searchModelList;

    public SearchAdapter(Context context, List<ResultsItem> searchModelList) {
        this.context = context;
        this.searchModelList = searchModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_search, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultsItem  searchModel= searchModelList.get(position);
        Glide.with(context)
                .load(searchModel.getUrls().getThumb())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return searchModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
        }
    }
}
