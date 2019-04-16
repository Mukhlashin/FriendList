package com.example.friendlist;

import android.content.Intent;
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

public class AddUser extends AppCompatActivity {

    EditText edtNama, edtEmail, edtPassword, edtRepass;
    Button btnSimpan;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        initView();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = edtNama.getText().toString();
                String email = edtEmail.getText().toString();
                String pass = edtPassword.getText().toString();
                String repass = edtRepass.getText().toString();

                if (pass.equals(repass)) {

                    Call<Status> addData = apiInterface.addUser(nama, email, pass);
                    addData.enqueue(new Callback<Status>() {
                        @Override
                        public void onResponse(Call<Status> call, Response<Status> response) {
                            Status status = response.body();
                            Toast.makeText(AddUser.this, "Berhasil menambahkan user", Toast.LENGTH_SHORT).show();

                            finish();
                        }

                        @Override
                        public void onFailure(Call<Status> call, Throwable t) {
                            Toast.makeText(AddUser.this, "Error : " + t, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    edtRepass.setError("Sandi berbeda");
                }
            }
        });
    }
        private void initView() {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

            edtEmail = findViewById(R.id.edt_email);
            edtNama = findViewById(R.id.edt_nama);
            edtPassword = findViewById(R.id.edt_pass);
            edtRepass = findViewById(R.id.edt_repass);
            btnSimpan = findViewById(R.id.btn_simpan);

    }

}
