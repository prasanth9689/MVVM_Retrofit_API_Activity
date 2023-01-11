package com.skyblue.mvvmretrofitactivity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.skyblue.mvvmretrofitactivity.R;
import com.skyblue.mvvmretrofitactivity.models.UserModel;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    List<UserModel> userlist;

    public UserListAdapter(List<UserModel>list){
        this.userlist = list;
    }

    public void updateUserList(List<UserModel> list){
        this.userlist = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_model, parent, false);
        return new UserViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.UserViewHolder holder, int position) {
        holder.txtUserName.setText(userlist.get(position).getName());
        Glide.with(holder.imageView.getContext())
                .load(userlist.get(position).getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
       if (this.userlist!=null)
           return this.userlist.size();
       else
           return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txtUserName;
        ImageView imageView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txt_name);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
