package com.example.cemilan;

import com.example.cemilan.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiInterface {
    @GET("login.php")
    Call<User> login(@Query("user") String user, @Query("pass") String pass);

    @GET("register.php")
    Call<String> register(@Query("user") String user, @Query("pass") String pass);

}
