package com.foodgram;

import com.android.volley.toolbox.StringRequest;

import java.io.File;
import java.lang.reflect.Parameter;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UploadAPI {
    @Multipart
    @POST("post/image")
      Call<ResponseBody> imgUpload(@Part MultipartBody.Part part);
//    Call<ResponseBody> imgUpload(@Field("file") String s, @Part MultipartBody.Part part);
//    Call<ResponseBody> imgUpload(@Path("file") String s, @Part MultipartBody.Part part);
//    Call<ResponseBody> imgUpload(@Part MultipartBody.Part part, @Path ("file") String s);
}
