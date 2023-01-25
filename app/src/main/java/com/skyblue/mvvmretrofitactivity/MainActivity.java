package com.skyblue.mvvmretrofitactivity;

import androidx.annotation.NonNull;
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
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;

import com.skyblue.mvvmretrofitactivity.adapters.UserListAdapter;
import com.skyblue.mvvmretrofitactivity.databinding.ActivityMainBinding;
import com.skyblue.mvvmretrofitactivity.models.UserModel;
import com.skyblue.mvvmretrofitactivity.retrofit.APIClient;
import com.skyblue.mvvmretrofitactivity.retrofit.APIInterface;
import com.skyblue.mvvmretrofitactivity.viewmodels.UserListViewModel;

import java.util.IllegalFormatCodePointException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    APIInterface apiInterface;
    List<UserModel> userlist;
    UserListViewModel listViewModel;
    UserListAdapter adapter;

    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        apiInterface = APIClient.getRetroClient().create(APIInterface.class);

        initScrollListener();

        // responsible for measuring and positioning item,
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        // adding array list to our adapter class.
        adapter = new UserListAdapter(userlist);

        // setting adapter to our recycler view.
        binding.recyclerView.setAdapter(adapter);

        // framework provides the ViewModels, a special mechanism is required to create instances of them
        listViewModel = new ViewModelProvider(this).get(UserListViewModel.class);

        /*
         Attach the Observer object to the LiveData object using the observe() method. The observe() method takes a LifecycleOwner object.
         This subscribes the Observer object to the LiveData object so that it is notified of changes. You usually attach the Observer object
         in a UI controller, such as an activity or fragment.
         */
        listViewModel.getUserListObserver().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> list) {
                // check user array list empty or null
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
        // call retrofit api
        listViewModel.makeApiCall();
    }

    private void initScrollListener() {
        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == userlist.size() - 2) {
                        //bottom of list!
                        userlist.add(null);
                        adapter.notifyItemInserted(userlist.size() - 1);
                        Toast.makeText(MainActivity.this, "Last position ", Toast.LENGTH_SHORT).show();

                        isLoading = true;

                        Call<List<UserModel>> call = apiInterface.getUserList();

                        call.enqueue(new Callback<List<UserModel>>() {
                            @Override
                            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                                isLoading = false;

                                userlist.remove(userlist.size() - 1);
                                int scrollPosition = userlist.size();
                                adapter.notifyItemRemoved(scrollPosition);

                                userlist = response.body();

                             //   userlist.add(userModel);
                              adapter.notifyDataSetChanged();

                            }

                            @Override
                            public void onFailure(Call<List<UserModel>> call, Throwable t) {

                            }
                        });
                    }
                }
            }
        });
    }
}