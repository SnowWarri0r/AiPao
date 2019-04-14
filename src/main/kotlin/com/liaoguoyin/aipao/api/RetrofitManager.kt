package com.liaoguoyin.aipao.api

import com.liaoguoyin.aipao.bean.InfoBean
import com.liaoguoyin.aipao.bean.PointsBean
import com.liaoguoyin.aipao.bean.TokenBean
import com.liaoguoyin.aipao.bean.UploadStatusBean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitManager : ApiService {
    val apiService: ApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://client3.aipao.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java) // 通过interface创建动态代理
    }

    // 生成 ServiceMethod，拿到Call
    override fun checkToken(IMEICode: String): Call<TokenBean> {
        return apiService.checkToken(IMEICode)
    }

    override fun getInfo(token: String): Call<InfoBean> {
        return apiService.getInfo(token)
    }

    override fun running(token: String, map: Map<String, String>): Call<PointsBean> {
        return apiService.running(token, map)
    }

    override fun uploadRecord(token: String, Map: Map<String, String>): Call<UploadStatusBean> {
        return apiService.uploadRecord(token, Map)
    }

}
