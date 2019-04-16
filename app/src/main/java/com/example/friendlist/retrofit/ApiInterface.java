package com.example.friendlist.retrofit;

import com.example.friendlist.model.Status;
import com.example.friendlist.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("RPL-D/get-all-user.php")
    Call<List<User>> getAllUser();

    @FormUrlEncoded
    @POST("RPL-D/insert-user.php")
    Call<Status> addUser(@Field("nama") String nama, @Field("email") String email, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("RPL-D/delete-user.php")
    Call<Status> deleteUser(@Field("nama") String nama);

}
