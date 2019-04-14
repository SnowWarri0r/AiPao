package com.liaoguoyin.aipao

import com.liaoguoyin.aipao.api.RetrofitManager
import com.liaoguoyin.aipao.bean.InfoBean
import com.liaoguoyin.aipao.bean.PointsBean
import com.liaoguoyin.aipao.bean.TokenBean
import com.liaoguoyin.aipao.bean.UploadStatusBean
import com.liaoguoyin.aipao.utils.Utils.encrypt
import com.liaoguoyin.aipao.utils.Utils.random
import retrofit2.Call

class client(val IMEICode: String) {
    private val retrofitManager = RetrofitManager.apiService
    private var token: String = ""
    private var keyInfo: HashMap<String, String?> = HashMap()

    fun checkImeicode() {
        val tokenCall: Call<TokenBean> = retrofitManager.checkToken(IMEICode) //TODO 可以做callback
        val tokenBean: TokenBean? = tokenCall.execute().body()

        token = tokenBean!!.data.token
        println(tokenCall.request())
        println(tokenBean)
    }

    fun getInfo() {
        val getInfoCall: Call<InfoBean> = retrofitManager.getInfo(token)
        val infoBean: InfoBean? = getInfoCall.execute().body()

        keyInfo.set("uid", infoBean!!.data.user.userID.toString())
        keyInfo.set("name", infoBean.data.user.userName)
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
        val distance = keyInfo["distance"]!!.toInt() + random(1, 5)
        val speed = random(keyInfo["minSpeed"]!!.toDouble(), keyInfo["maxSpeed"]!!.toDouble())
        val time = (distance / speed).toInt()
        val runId = keyInfo.get("runId") ?: "runId null"
        val map: Map<String, String> = mapOf(
                "S1" to runId, // 本次跑步记录的id
                "S4" to encrypt(time), // 跑步时间 s
                "S5" to encrypt(distance), // 跑步距离 m
                "S6" to "A0A2A1A3A0", // 跑步关键点 形似: A0A2A1A3A0
                "S7" to "1", // 本次跑步的状态 1表示成功，0、2等非1值表示失败
                "S8" to "czplgyznba", // 加密原字段
                "S9" to encrypt(random(1234, 1998)) // 跑步步数 m
        )

        val uploadCall: Call<UploadStatusBean> = retrofitManager.uploadRecord(token, map)
        val uploadStatusBean: UploadStatusBean? = uploadCall.execute().body()

        println("跑步中...\n距离：$distance m，速度：$speed m/s，时间：$time s")
        println(uploadCall.request())
        println(uploadStatusBean)
        println("成功！点击链接查看记录：" +
                "http://sportsapp.aipao.me/Manage/UserDomain_SNSP_Records.aspx/MyResutls?userId=${keyInfo["uid"]}")
    }
}
