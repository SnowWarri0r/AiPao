package com.liaoguoyin.aipao

import com.liaoguoyin.aipao.bean.InfoBean
import com.liaoguoyin.aipao.bean.PointsBean
import com.liaoguoyin.aipao.bean.TokenBean
import retrofit2.Call

class client(val IMEICode: String) {
    private val retrofitManager = RetrofitManager()
    private var token: String = ""
    private var keyInfo: HashMap<String, String?>? = null

    fun checkImeicode() {
        val tokenCall: Call<TokenBean> = retrofitManager.checkToken(IMEICode) //TODO 可以做callback
        val tokenBean: TokenBean? = tokenCall.execute().body()

        //        println(tokenCall.request())
        println(tokenBean)
        token = tokenBean!!.data.token
    }

    fun getInfo() {
        val getInfoCall: Call<InfoBean> = retrofitManager.getInfo(token)
        val infoBean: InfoBean? = getInfoCall.execute().body()

        //        println(getInfoCall)
        println(infoBean)
        keyInfo?.set("uid", infoBean!!.data.user.userID.toString())
        keyInfo?.set("name", infoBean!!.data.user.userName)
        keyInfo?.set("distance", infoBean!!.data.schoolRun.lengths.toString())
        keyInfo?.set("minSpeed", infoBean!!.data.schoolRun.minSpeed.toString())
        keyInfo?.set("maxSpeed", infoBean!!.data.schoolRun.maxSpeed.toString())
        keyInfo?.set("gender", infoBean!!.data.schoolRun.sex)
        keyInfo?.set("school", infoBean!!.data.schoolRun.schoolName)
    }

    fun running() {
        val map: Map<String, String> = mapOf<String, String>(
                "S1" to "40.62844",
                "S2" to "120.791051",
                "S3" to (keyInfo?.get("distance") ?: "3000")
        ) //错误的话默认3000 TODO test location

        val runningCall: Call<PointsBean> = retrofitManager.running(token, map)
        val pointsBean: PointsBean? = runningCall.execute().body()
        keyInfo?.set("runId", pointsBean!!.data.runId)

        //        println(runningCall.request())
        println(pointsBean)
    }

    fun upload() {
        val hashMap = HashMap<String, String>()

        hashMap.put("S1", keyInfo!!.get("runId")!!) // 本次跑步记录的id
        //        hashMap.put("S4", encrypt(time));// 跑步时间 s
        //        hashMap.put("S5", encrypt(distance));// 跑步距离 m
        //        hashMap.put("S6", "A0A2A1A3A0");// 跑步关键点 形似: A0A2A1A3A0
        //        hashMap.put("S7", "1");// 本次跑步的状态 1表示成功，0、2等非1值表示失败
        //        hashMap.put("S8", "czplgyznba");// 加密原字段
        //        hashMap.put("S9", encrypt(randomUtils(1198, 1889)));// 跑步步数


    }
}