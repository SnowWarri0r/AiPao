package com.liaoguoyin.aipao.bean

import com.google.gson.annotations.SerializedName

data class InfoBean(
    @SerializedName("Success")
    val success: Boolean, // true
    @SerializedName("Data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("User")
        val user: User,
        @SerializedName("SchoolRun")
        val schoolRun: SchoolRun
    ) {
        data class User(
            @SerializedName("UserID")
            val userID: Int, // 396928
            @SerializedName("NickName")
            val nickName: String, // CH
            @SerializedName("UserName")
            val userName: String, // 1710030103
            @SerializedName("Sex")
            val sex: String, // 男
            @SerializedName("Province")
            val province: Any, // null
            @SerializedName("City")
            val city: Any, // null
            @SerializedName("Country")
            val country: Any, // null
            @SerializedName("HeadImgUrl")
            val headImgUrl: String,
            @SerializedName("Mobile")
            val mobile: Any, // null
            @SerializedName("MobileVerifyCode")
            val mobileVerifyCode: Any, // null
            @SerializedName("IsMoblileVerify")
            val isMoblileVerify: String, // 0
            @SerializedName("Weights")
            val weights: Double, // 0.0
            @SerializedName("BMI")
            val bMI: Double, // 0.0
            @SerializedName("Heights")
            val heights: Double, // 0.0
            @SerializedName("Birthday")
            val birthday: String, // 0001-01-01 00:00:00
            @SerializedName("OldYears")
            val oldYears: Int, // 0
            @SerializedName("IsInfoOk")
            val isInfoOk: String, // 0
            @SerializedName("WXNickName")
            val wXNickName: Any, // null
            @SerializedName("WXSex")
            val wXSex: Any, // null
            @SerializedName("IsStationOpen")
            val isStationOpen: String, // 0
            @SerializedName("IsBgMusic")
            val isBgMusic: String, // 1
            @SerializedName("IsReciveMsg")
            val isReciveMsg: String, // 1
            @SerializedName("IsSchoolMode")
            val isSchoolMode: String, // 1
            @SerializedName("Level_Lengh")
            val levelLengh: Int, // 0
            @SerializedName("Level_Lengh_Date")
            val levelLenghDate: String, // 2015-01-01 00:00:00
            @SerializedName("Days_Start")
            val daysStart: Int, // 0
            @SerializedName("Days_Start_Date")
            val daysStartDate: String // 2015-01-01 00:00:00
        )

        data class SchoolRun(
            @SerializedName("Sex")
            val sex: String, // 男
            @SerializedName("SchoolId")
            val schoolId: String, // lntu
            @SerializedName("SchoolName")
            val schoolName: String, // 辽宁工程技术大学
            @SerializedName("MinSpeed")
            val minSpeed: Double, // 1.90
            @SerializedName("MaxSpeed")
            val maxSpeed: Double, // 4.0
            @SerializedName("Lengths")
            val lengths: Int, // 3000
            @SerializedName("IsNeedPhoto")
            val isNeedPhoto: String, // 0
            @SerializedName("IsShowAd")
            val isShowAd: Int // 0
        )
    }
}