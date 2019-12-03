package com.foodgram;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    private static Retrofit retrofit;

    private static String Base_Url = "http://10.31.31.219:8080/";

    public static Retrofit getRetrofit(){
        OkHttpClient httpClient = new OkHttpClient.Builder().build(); //Volley Network Calls
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Base_Url).
                    addConverterFactory(GsonConverterFactory.create()).client(httpClient).build();
        }
        return retrofit;
    }

}
