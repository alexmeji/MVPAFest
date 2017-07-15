package com.alexmejicanos.mvpandroid.rest.services;

import com.alexmejicanos.mvpandroid.rest.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by alexmejicanos on 15/07/17.
 */

public interface UsersEndpoint {
    @FormUrlEncoded
    @POST("login")
    Call<User> doLogin(@Field("username") String username, @Field("password") String password);
}
