package com.skyblue.mvvmretrofitactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.skyblue.mvvmretrofitactivity.adapters.UserListAdapter;
import com.skyblue.mvvmretrofitactivity.databinding.ActivityMainBinding;
import com.skyblue.mvvmretrofitactivity.models.UserModel;
import com.skyblue.mvvmretrofitactivity.viewmodels.UserListViewModel;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<UserModel> userlist;
    UserListViewModel listViewModel;
    UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        adapter = new UserListAdapter(userlist);
        binding.recyclerView.setAdapter(adapter);

        listViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        listViewModel.getUserListObserver().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> list) {
                if (list!=null){
                    userlist = list;
                    adapter.updateUserList(list);
                    binding.noDataFoundTxt.setVisibility(View.GONE);
                }
                if (list == null){
                    binding.recyclerView.setVisibility(View.GONE);
                    binding.noDataFoundTxt.setVisibility(View.VISIBLE);
                }
            }
        });
        listViewModel.makeApiCall();
    }
}