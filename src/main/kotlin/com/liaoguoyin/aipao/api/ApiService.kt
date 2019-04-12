package com.liaoguoyin.aipao.api

import com.liaoguoyin.aipao.bean.BasicInfo
import com.liaoguoyin.aipao.bean.CheckToken
import com.liaoguoyin.aipao.bean.RunningPoints
import com.liaoguoyin.aipao.bean.UploadStatus
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("%7Btoken%7D/QM_Users/Login_AndroidSchool")
    fun checkToken(@Query("IMEICode") IMEICode: String): Call<CheckToken>

    @GET("{token}/QM_Users/GS")
    fun getInfo(@Path("token") token: String): Call<BasicInfo>

    @GET("{token}/QM_Runs/SRS")
    //?S1=40.62844&S2=120.791051&S3=3000
    fun Running(
        @Path("token") token: String
        , @QueryMap hashMap: HashMap<String, String>
    ): Call<RunningPoints>

    @GET("{token}/QM_Runs/ES")
    //?S1=5a7b369bb9bf489691fe27b2c1580ad8&S4=vuzz&S5=tuuj&S6=A0A2A1A3A0&S7=1&S8=uvhtzjcfwp&S9=hjft
    fun UploadStatus(
        @Path("token") token: String
        , @QueryMap hashMap: HashMap<String, String>
    ): Call<UploadStatus>

}