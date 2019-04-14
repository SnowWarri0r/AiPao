package com.liaoguoyin.aipao.api

import com.liaoguoyin.aipao.bean.InfoBean
import com.liaoguoyin.aipao.bean.PointsBean
import com.liaoguoyin.aipao.bean.TokenBean
import com.liaoguoyin.aipao.bean.UploadStatusBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("%7Btoken%7D/QM_Users/Login_AndroidSchool")
    fun checkToken(@Query("IMEICode") IMEICode: String): Call<TokenBean>

    @GET("{token}/QM_Users/GS")
    fun getInfo(@Path("token") token: String): Call<InfoBean>

    @GET("{token}/QM_Runs/SRS")
    fun running(@Path("token") token: String, @QueryMap map: Map<String, String>): Call<PointsBean>

    @GET("{token}/QM_Runs/ES")
    fun uploadRecord(@Path("token") token: String, @QueryMap Map: Map<String, String>): Call<UploadStatusBean>

}
