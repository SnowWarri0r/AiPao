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

    /***
     * cHeckIMEicode，getTOken
     */
    @GET("%7Btoken%7D/QM_Users/Login_AndroidSchool")
    fun checkToken(@Query("IMEICode") IMEICode: String): Call<TokenBean>

    /**
     * use token，getInfo
     */
    @GET("{token}/QM_Users/GS")
    fun getInfo(@Path("token") token: String): Call<InfoBean>

    /**
     * use token、log、lit、distance，get runid、points
     */
    @GET("{token}/QM_Runs/SRS")
    //?S1=40.62844&S2=120.791051&S3=3000
    fun Running(@Path("token") token: String,
                @QueryMap map: Map<String, String>
    ): Call<PointsBean>

    /**
     * upload recorder
     */
    @GET("{token}/QM_Runs/ES")
    //?S1=5a7b369bb9bf489691fe27b2c1580ad8&S4=vuzz&S5=tuuj&S6=A0A2A1A3A0&S7=1&S8=uvhtzjcfwp&S9=hjft
    fun UploadStatus(@Path("token") token: String,
                     @QueryMap Map: Map<String, String>
    ): Call<UploadStatusBean>

}
