package com.foodgram;

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

public interface UploadAPI {
    @Multipart
    @POST("post/image")
//    Call<ResponseBody> imgUpload(@Part("file") MultipartBody.Part part);
    Call<ResponseBody> imgUpload(@Part MultipartBody.Part part);
}
