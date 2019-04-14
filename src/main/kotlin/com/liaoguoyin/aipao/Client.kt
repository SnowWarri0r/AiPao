package com.liaoguoyin.aipao

import com.liaoguoyin.aipao.api.RetrofitManager
import com.liaoguoyin.aipao.bean.InfoBean
import com.liaoguoyin.aipao.bean.PointsBean
import com.liaoguoyin.aipao.bean.TokenBean
import com.liaoguoyin.aipao.bean.UploadStatusBean
import com.liaoguoyin.aipao.utils.Utils.encrypt
import com.liaoguoyin.aipao.utils.Utils.random
import retrofit2.Call
import java.lang.NullPointerException

class client(val IMEICode: String) {
    private val retrofitManager = RetrofitManager.apiService
    private var token: String = ""
    var keyInfo: HashMap<String, String?> = HashMap()

    fun checkImeicode() {
        val tokenCall: Call<TokenBean> = retrofitManager.checkToken(IMEICode) //TODO 可以做callback
        val tokenBean: TokenBean? = tokenCall.execute().body()

        try {
            token = tokenBean!!.data.token
        } catch (e: NullPointerException) {
            println("IMEICode失效！！")
        }
        println(tokenCall.request())
        println(tokenBean)
    }

    fun getInfo() {
        val getInfoCall: Call<InfoBean> = retrofitManager.getInfo(token)
        val infoBean: InfoBean? = getInfoCall.execute().body()

        keyInfo.set("uid", infoBean!!.data.user.userID.toString())
        keyInfo.set("name", infoBean.data.user.nickName)
        keyInfo.set("distance", infoBean.data.schoolRun.lengths.toString())
        keyInfo.set("minSpeed", infoBean.data.schoolRun.minSpeed.toString())
        keyInfo.set("maxSpeed", infoBean.data.schoolRun.maxSpeed.toString())
        keyInfo.set("gender", infoBean.data.schoolRun.sex)
        keyInfo.set("school", infoBean.data.schoolRun.schoolName)
        println(getInfoCall.request())
        println(infoBean)
    }

    fun running() {
        val map: Map<String, String> = mapOf(
                "S1" to "40.62844",
                "S2" to "120.791051",
                "S3" to (keyInfo.get("distance") ?: "3000")
        ) //错误的话默认3000 TODO test location

        val runningCall: Call<PointsBean> = retrofitManager.running(token, map)
        val pointsBean: PointsBean? = runningCall.execute().body()
        keyInfo.set("runId", pointsBean!!.data.runId)
        println(runningCall.request())
        println(pointsBean)
    }

    fun upload() {
        val runningDistance = (keyInfo["distance"]!!.toInt() + random(1, 5)).also { keyInfo.set("runningDistance",it.toString()) }
        val runningSpeed = random(keyInfo["minSpeed"]!!.toDouble(), keyInfo["maxSpeed"]!!.toDouble()).also { keyInfo.set("runningSpeed",it.toString()) }
        val runningTime = (runningDistance / runningSpeed).toInt().also { keyInfo.set("runningTime",it.toString()) }
        val runId = keyInfo.get("runId") ?: "runId null"
        val map: Map<String, String> = mapOf(
                "S1" to runId, // 本次跑步记录的id
                "S4" to encrypt(runningTime), // 跑步时间 s
                "S5" to encrypt(runningDistance), // 跑步距离 m
                "S6" to "A0A2A1A3A0", // 跑步关键点 形似: A0A2A1A3A0
                "S7" to "1", // 本次跑步的状态 1表示成功，0、2等非1值表示失败
                "S8" to "czplgyznba", // 加密原字段
                "S9" to encrypt(random(1234, 1998)) // 跑步步数 m
        )

        val uploadCall: Call<UploadStatusBean> = retrofitManager.uploadRecord(token, map)
        val uploadStatusBean: UploadStatusBean? = uploadCall.execute().body()

        println(uploadCall.request())
        println("跑步中...\n距离：$runningDistance m，速度：$runningSpeed m/s，时间：$runningTime s")
        println(uploadStatusBean)
    }
}
