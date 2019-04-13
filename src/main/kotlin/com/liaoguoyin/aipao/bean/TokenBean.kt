package com.liaoguoyin.aipao.bean

import com.google.gson.annotations.SerializedName

data class TokenBean(
    @SerializedName("Success")
    val success: Boolean, // true
    @SerializedName("Data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("Token")
        val token: String, // 9775c866af6d42ceb988670b5a5404f2
        @SerializedName("UserId")
        val userId: Int, // 396928
        @SerializedName("IMEICode")
        val iMEICode: String, // f23726bafda744f0becf5811b294a6d1
        @SerializedName("AndroidVer")
        val androidVer: Double, // 2.14
        @SerializedName("AppleVer")
        val appleVer: Double, // 1.24
        @SerializedName("WinVer")
        val winVer: Double // 1.0
    )
}