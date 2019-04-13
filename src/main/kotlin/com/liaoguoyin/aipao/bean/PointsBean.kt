package com.liaoguoyin.aipao.bean

import com.google.gson.annotations.SerializedName

data class PointsBean(
    @SerializedName("Success")
    val success: Boolean, // true
    @SerializedName("Data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("StartTime")
        val startTime: String, // 2019-04-02 21:54:37
        @SerializedName("RunId")
        val runId: String, // 5a7b369bb9bf489691fe27b2c1580ad8
        @SerializedName("FUserId")
        val fUserId: Int, // 0
        @SerializedName("FieldId")
        val fieldId: Int, // 289
        @SerializedName("Routes")
        val routes: String, // A0A2A1A3A0
        @SerializedName("LifeValue")
        val lifeValue: Int, // 0
        @SerializedName("Powers")
        val powers: Int, // 0
        @SerializedName("LenValue")
        val lenValue: Double, // 0.0
        @SerializedName("Points")
        val points: List<Point>,
        @SerializedName("FiledName")
        val filedName: String,
        @SerializedName("Area")
        val area: String,
        @SerializedName("SenseType")
        val senseType: String, // 0
        @SerializedName("ImgUrl")
        val imgUrl: String,
        @SerializedName("Major")
        val major: Int // 0
    ) {
        data class Point(
            @SerializedName("PointNo")
            val pointNo: String, // A0
            @SerializedName("Lat")
            val lat: Double, // 40.628369
            @SerializedName("Lng")
            val lng: Double, // 120.791004
            @SerializedName("Minor")
            val minor: Int // 1
        )
    }
}