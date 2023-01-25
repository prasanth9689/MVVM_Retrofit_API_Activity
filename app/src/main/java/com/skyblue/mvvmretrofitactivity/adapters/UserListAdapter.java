package com.skyblue.mvvmretrofitactivity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.skyblue.mvvmretrofitactivity.R;
import com.skyblue.mvvmretrofitactivity.models.UserModel;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_model, parent, false);
            return new UserViewHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof UserViewHolder) {
            UserViewHolder userViewHolder = (UserViewHolder) holder;

            userViewHolder.txtUserName.setText(userlist.get(position).getName());
            userViewHolder.txtPostText.setText(userlist.get(position).getPost_text());
            Glide.with(userViewHolder.imageView.getContext())
                    .load(userlist.get(position).getImage())
                    .into(userViewHolder.imageView);

            Glide.with(userViewHolder.postImageView.getContext())
                    .load(userlist.get(position).getPost_image())
                    .into(userViewHolder.postImageView);

        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return userlist == null ? 0 : userlist.size();
    }

    /**
     * The following method decides the type of ViewHolder to display in the RecyclerView
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return userlist.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txtUserName, txtPostText;
        ImageView imageView, postImageView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txt_name);
            imageView = itemView.findViewById(R.id.imageView);
            postImageView = itemView.findViewById(R.id.postImageView);
            txtPostText = itemView.findViewById(R.id.post_text);
        }
    }

    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;
        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBarloading);
        }
    }
}
