package com.example.bottomnav.Service;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("register.php?apicall=")
    Call<ServerResponse> operation(@Body ServerRequest request);
}
