package com.skyblue.mvvmretrofitactivity.retrofit;

import com.skyblue.mvvmretrofitactivity.models.UserModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/user_list.php")
    Call<List<UserModel>> getUserList();
}
