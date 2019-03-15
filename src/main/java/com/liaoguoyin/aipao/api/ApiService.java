package com.liaoguoyin.aipao.api;

import com.liaoguoyin.aipao.api.Entity.InfoEntity;
import com.liaoguoyin.aipao.api.Entity.LoginEntity;
import com.liaoguoyin.aipao.api.Entity.runningEntity;
import com.liaoguoyin.aipao.api.Entity.uploadEntity;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface ApiService {

    @GET("token/QM_Users/LoginSchool")
    Call<LoginEntity> imeilogin(@Query("IMEICode") String imeicode);

    @GET("{token}/QM_Users/GS")
    Call<InfoEntity> getinfo(@Path("token") String token);

    @GET("{token}/QM_Runs/SRS?S1=40.62825&S2=120.79107&S3=3000")
    Call<runningEntity> startRunning(@Path("token") String token);

    @GET("{token}/QM_Runs/ES")
    Call<uploadEntity> uploadRecord(@Path("token") String token, @QueryMap Map<String, String> record);

}