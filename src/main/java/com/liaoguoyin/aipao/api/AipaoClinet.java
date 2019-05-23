package com.liaoguoyin.aipao.api;

import com.liaoguoyin.aipao.api.Entity.InfoEntity;
import com.liaoguoyin.aipao.api.Entity.LoginEntity;
import com.liaoguoyin.aipao.api.Entity.runningEntity;
import com.liaoguoyin.aipao.api.Entity.uploadEntity;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.liaoguoyin.aipao.api.utils.encrypt;
import static com.liaoguoyin.aipao.api.utils.randomUtils;

public class AipaoClinet {
    public int UserId;
    public StringBuilder output = new StringBuilder("\n");
    private ApiService apiService;
    private String token;
    private String runid;
    private int distance;
    private int time;
    private double minSpeed;
    private double maxSpeed;
    private Retrofit retrofitAndroid;
    private Retrofit retrofitIOS;

    public AipaoClinet() {
        retrofitAndroid = new Retrofit.Builder()
                .baseUrl("http://client3.aipao.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitIOS = new Retrofit.Builder()
                .baseUrl("http://client4.aipao.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofitAndroid.create(ApiService.class);
    }

    public void imeiLogin(String imeicode) throws IOException {
        System.out.println("IMEICode: \t\t" + imeicode);
        Call<LoginEntity> dataEntityCall = apiService.imeilogin(imeicode);
        Response<LoginEntity> responseLogin = dataEntityCall.execute();
        LoginEntity loginEntity = responseLogin.body();

        if (!loginEntity.isSuccess()) {
            apiService = retrofitIOS.create(ApiService.class);
            dataEntityCall = apiService.imeilogin(imeicode);
            responseLogin = dataEntityCall.execute();
            loginEntity = responseLogin.body();
        }

        token = loginEntity.getData().getToken();
        UserId = loginEntity.getData().getUserId();
        output.append(loginEntity.toString());
        System.out.println("Login: \t" + loginEntity.toString());
    }

    public void getBasicInfo() throws IOException {
        Call<InfoEntity> infoEntityCall = apiService.getinfo(token);
        InfoEntity infoEntity = infoEntityCall.execute().body();

        output.append(infoEntity.toString());
        distance = infoEntity.getData().getSchoolRun().getLengths();
        minSpeed = infoEntity.getData().getSchoolRun().getMinSpeed();
        maxSpeed = infoEntity.getData().getSchoolRun().getMaxSpeed();
        System.out.println("正在获取个人信息: \t" + infoEntity.toString());
    }

    public void running() throws IOException {
        Map<String, String> locationmap = new HashMap<>();
        locationmap.put("S1", "40.62825");
        locationmap.put("S2", "120.79107");
        locationmap.put("S3", String.valueOf(distance));
        distance = randomUtils(distance, distance + 5);
        time = randomUtils(distance / maxSpeed, distance / minSpeed);

        System.out.println("distance / maxSpeed:" + distance / maxSpeed);
        System.out.println("distance / min:" + distance / minSpeed);

        Call<runningEntity> running = apiService.startRunning(token, locationmap);
        runningEntity runningEntity = running.execute().body();

        output.append(runningEntity.toString());
        runid = runningEntity.getData().getRunId();
        System.out.println("获取本次跑步信息: " + runningEntity.toString());
        System.out.print("开始跑步, 取得RunId: \t");
        System.out.print("本次路程: (米)" + distance);
        System.out.println("\t用时: (秒)" + time);
    }

    public void uploadRecord() throws IOException {
        Map<String, String> record = new HashMap<>();
        record.put("S1", runid);// 本次跑步记录的id
        record.put("S4", encrypt(time));// 跑步时间 s
        record.put("S5", encrypt(distance));// 跑步距离 m
        record.put("S6", "A0A2A1A3A0");// 跑步关键点 形似: A0A2A1A3A0
        record.put("S7", "1");// 本次跑步的状态 1表示成功，0、2等非1值表示失败
        record.put("S8", "xfvdmyirsg");// 加密原字段
        record.put("S9", encrypt(randomUtils(1198, 1889)));// 跑步步数

        System.out.print("正在上传跑步记录: \t");
        Call<uploadEntity> uploadRecord = apiService.uploadRecord(token, record);
        System.out.println(uploadRecord.execute().body().getData());
    }

}