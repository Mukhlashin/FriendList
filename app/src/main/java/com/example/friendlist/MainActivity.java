package com.example.friendlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.friendlist.adapter.AdapterRv;
import com.example.friendlist.model.User;
import com.example.friendlist.retrofit.ApiClient;
import com.example.friendlist.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    ApiInterface apiInterface;
    AdapterRv adapter;
    List<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getDataFromServer();
    }

    private void getDataFromServer() {

        Call<List<User>> getAllUser = apiInterface.getAllUser();
        getAllUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                listUser = response.body();
                setRecItems();

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Log.e("Gagal", "onFailure" + t);

            }
        });
    }

    private void setRecItems() {
        adapter = new AdapterRv(listUser, this);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapter);
    }

    private void initView() {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        rvMain = findViewById(R.id.rv_main);
    }

    public void goToAddUser(View v) {
        startActivity(new Intent(this, AddUser.class));
    }

    public void goToDeleteUser(View v) {
        startActivity(new Intent(this, DeleteUser.class));
    }
}
