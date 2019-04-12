package com.liaoguoyin.aipao.bean

data class CheckToken(
    val `data`: Data,
    val success: Boolean // true
) {
    data class Data(
        val androidVer: Double, // 2.14
        val appleVer: Double, // 1.24
        val iMEICode: String, // f23726bafda744f0becf5811b294a6d1
        val token: String, // 9775c866af6d42ceb988670b5a5404f2
        val userId: Int, // 396928
        val winVer: Int // 1
    )
}
