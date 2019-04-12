package com.liaoguoyin.aipao.bean

data class BasicInfo(
    val `data`: Data,
    val success: Boolean // true
) {
    data class Data(
        val schoolRun: SchoolRun,
        val user: User
    ) {
        data class SchoolRun(
            val isNeedPhoto: String, // 0
            val isShowAd: Int, // 0
            val lengths: Int, // 3000
            val maxSpeed: Int, // 4
            val minSpeed: Double, // 1.9
            val schoolId: String, // lntu
            val schoolName: String, // 辽宁工程技术大学
            val sex: String // 男
        )

        data class User(
            val bMI: Int, // 0
            val birthday: String, // 0001-01-01 00:00:00
            val city: Any, // null
            val country: Any, // null
            val daysStart: Int, // 0
            val daysStartDate: String, // 2015-01-01 00:00:00
            val headImgUrl: String,
            val heights: Int, // 0
            val isBgMusic: String, // 1
            val isInfoOk: String, // 0
            val isMoblileVerify: String, // 0
            val isReciveMsg: String, // 1
            val isSchoolMode: String, // 1
            val isStationOpen: String, // 0
            val levelLengh: Int, // 0
            val levelLenghDate: String, // 2015-01-01 00:00:00
            val mobile: Any, // null
            val mobileVerifyCode: Any, // null
            val nickName: String, // CH
            val oldYears: Int, // 0
            val province: Any, // null
            val sex: String, // 男
            val userID: Int, // 396928
            val userName: String, // 1710030103
            val wXNickName: Any, // null
            val wXSex: Any, // null
            val weights: Int // 0
        )
    }
}
