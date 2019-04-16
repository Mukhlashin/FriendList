package com.example.friendlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.friendlist.model.Status;
import com.example.friendlist.retrofit.ApiClient;
import com.example.friendlist.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteUser extends AppCompatActivity {

    EditText edtHapus;
    Button btnHapus;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        initView();

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nama = edtHapus.getText().toString();

                Call<Status> deleteData = apiInterface.deleteUser(nama);
                deleteData.enqueue(new Callback<Status>() {
                    @Override
                    public void onResponse(Call<Status> call, Response<Status> response) {
                        Status status = response.body();
                        Toast.makeText(DeleteUser.this, "Berhasil menghapus user " + nama, Toast.LENGTH_SHORT).show();

                        finish();
                    }

                    @Override
                    public void onFailure(Call<Status> call, Throwable t) {
                        Toast.makeText(DeleteUser.this, "Error : " + t, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    private void initView() {

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        edtHapus = findViewById(R.id.edt_hapus);
        btnHapus = findViewById(R.id.btn_hapus);
    }

}
