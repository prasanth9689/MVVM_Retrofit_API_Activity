package com.skyblue.mvvmretrofitactivity.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skyblue.mvvmretrofitactivity.models.UserModel;
import com.skyblue.mvvmretrofitactivity.retrofit.APIClient;
import com.skyblue.mvvmretrofitactivity.retrofit.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends ViewModel {
    private MutableLiveData<List<UserModel>> userlist;

    public UserListViewModel(){
        userlist = new MutableLiveData<>();
    }

    public MutableLiveData<List<UserModel>> getUserListObserver(){
        return userlist;
    }

    public void makeApiCall(){
        APIInterface apiInterface= APIClient.getRetroClient().create(APIInterface.class);
        Call<List<UserModel>> call=apiInterface.getUserList();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userlist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                userlist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });
    }
}
