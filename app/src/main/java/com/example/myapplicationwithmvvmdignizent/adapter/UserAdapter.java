package com.example.myapplicationwithmvvmdignizent.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationwithmvvmdignizent.R;
import com.example.myapplicationwithmvvmdignizent.databinding.ItemUserBinding;
import com.example.myapplicationwithmvvmdignizent.model.EventModel;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<EventModel.Data> users;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new ViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventModel.Data currentUser = users.get(position);
        holder.itemUserBinding.setEvent(currentUser);
    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        } else {
            return 0;
        }
    }

    public void setUserList(ArrayList<EventModel.Data> users) {
        this.users = users;
        notifyDataSetChanged();
    }
    public EventModel.Data getCurrentItemAt(int position) {
        return users.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding itemUserBinding;
        //private ItemUserBinding itemUserBinding;

        public ViewHolder(@NonNull ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;

        }
    }
}
