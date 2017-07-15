package com.alexmejicanos.mvpandroid.rest;

import com.alexmejicanos.mvpandroid.rest.services.UsersEndpoint;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexmejicanos on 15/07/17.
 */

public class ApiClient {
    private static String baseUrl = "http://52.89.117.243/api/";
    private static UsersEndpoint usersEndpoint;
    private static OkHttpClient.Builder httpClient;

    public static UsersEndpoint getMyApiClient() {
        if(usersEndpoint == null) {

            httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit= new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            usersEndpoint = retrofit.create(UsersEndpoint.class);
        }

        return usersEndpoint;
    }

    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

}
