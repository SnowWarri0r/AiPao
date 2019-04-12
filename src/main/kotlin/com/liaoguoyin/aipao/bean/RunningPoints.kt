package com.liaoguoyin.aipao.bean

data class RunningPoints(
    val `data`: Data,
    val success: Boolean // true
) {
    data class Data(
        val area: String,
        val fUserId: Int, // 0
        val fieldId: Int, // 289
        val filedName: String,
        val imgUrl: String,
        val lenValue: Double, // 0.0
        val lifeValue: Int, // 0
        val major: Int, // 0
        val points: List<Point>,
        val powers: Int, // 0
        val routes: String, // A0A2A1A3A0
        val runId: String, // 5a7b369bb9bf489691fe27b2c1580ad8
        val senseType: String, // 0
        val startTime: String // 2019-04-02 21:54:37
    ) {
        data class Point(
            val lat: Double, // 40.628369
            val lng: Double, // 120.791004
            val minor: Int, // 1
            val pointNo: String // A0
        )
    }
}
