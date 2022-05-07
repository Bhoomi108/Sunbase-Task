package com.butterfly.sunbase_task.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.butterfly.sunbase_task.API;
import com.butterfly.sunbase_task.Model.HomeModel.HomeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<HomeModel>> homelist;

    public LiveData<List<HomeModel>> getHomesData(){
        if (homelist==null){
            homelist=new MutableLiveData<List<HomeModel>>();

            loadHomeData();
        }
        return  homelist;
    }

    private void loadHomeData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<List<HomeModel>> call= api.getHomesData();

        call.enqueue(new Callback<List<HomeModel>>() {
            @Override
            public void onResponse(Call<List<HomeModel>> call, Response<List<HomeModel>> response) {
                homelist.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<HomeModel>> call, Throwable t) {
                Log.e("ERROR",""+t);
            }
        });
    }

}