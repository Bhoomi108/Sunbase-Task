package com.butterfly.sunbase_task;

import com.butterfly.sunbase_task.Model.HomeModel.HomeModel;
import com.butterfly.sunbase_task.Model.SearchModel.SearchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    String BASE_URL1="https://api.unsplash.com/";

    @GET("photos/?client_id=S_tS6VpWqMR1i2i36wh69q2bz3J1ICCHWuKC0VD8N0c")
    Call<List<HomeModel>> getHomesData();

    @GET("search/photos")
    Call<SearchModel> getSearchData(
            @Query("page") String page,
            @Query("query") String query,
            @Query("client_id") String client_id
    );

}
