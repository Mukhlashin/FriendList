package com.example.friendlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.friendlist.R;
import com.example.friendlist.model.User;

import java.util.List;

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.ViewHolder> {

    List<User> listUser;
    Context context;

    public AdapterRv(List<User> listUser, Context context) {
        this.listUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterRv.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_contact, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRv.ViewHolder viewHolder, int i) {
        viewHolder.setItems(listUser.get(i));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvEmail = itemView.findViewById(R.id.tv_email);
        }

        void setItems(User user) {
            tvNama.setText(user.getNamaUser());
            tvEmail.setText(user.getEmailUser());
        }


    }
}
