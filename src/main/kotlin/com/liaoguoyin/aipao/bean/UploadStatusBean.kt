package com.liaoguoyin.aipao.bean

import com.google.gson.annotations.SerializedName

data class UploadStatusBean(
    @SerializedName("Success")
    val success: Boolean, // true
    @SerializedName("Data")
    val `data`: String // success
)