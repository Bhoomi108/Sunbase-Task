package com.butterfly.sunbase_task.ui.dashboard;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.butterfly.sunbase_task.API;
import com.butterfly.sunbase_task.CONSTANT;
import com.butterfly.sunbase_task.Model.HomeModel.HomeModel;
import com.butterfly.sunbase_task.Model.SearchModel.ResultsItem;
import com.butterfly.sunbase_task.Model.SearchModel.SearchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<SearchModel> homelist;

    public LiveData<SearchModel> getSearchdata(String query, String page){
        if (homelist==null){
            homelist=new MutableLiveData<SearchModel>();

            loadSearchData(query, page);
        }
        return  homelist;
    }

    public void loadSearchData(String query, String page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<SearchModel> call= api.getSearchData(page, query, CONSTANT.clientID);

        call.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                if (page.equals("1")) {
                    homelist.setValue(response.body());
                } else  {
                    SearchModel searchModel = homelist.getValue();
                    List<ResultsItem>  newResult = searchModel.getResults();
                    newResult.addAll(response.body().getResults());
                    searchModel.setResults(newResult);
                    homelist.setValue(searchModel);
                }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                Log.e("ERROR",""+t);
            }
        });
    }
}