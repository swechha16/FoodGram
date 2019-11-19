package com.foodgram;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    private static Retrofit retrofit;

    private static String Static_Url = "http://coms-309-mg-1.cs.iastate.edu:8080/";

    public static Retrofit getRetrofit(){
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Static_Url).
                    addConverterFactory(GsonConverterFactory.create()).client(httpClient).build();
        }
        return retrofit;
    }

}
