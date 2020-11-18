package com.liaoguoyin.aipao;

import com.liaoguoyin.aipao.api.ApiService;
import com.liaoguoyin.aipao.api.RetrofitManager;
import com.liaoguoyin.aipao.bean.InfoBean;
import com.liaoguoyin.aipao.bean.LoginBean;
import com.liaoguoyin.aipao.bean.RunningInfoBean;
import com.liaoguoyin.aipao.bean.UploadBean;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.liaoguoyin.aipao.Utils.encrypt;
import static com.liaoguoyin.aipao.Utils.randomUtils;

public class AipaoClinet {
    private static ApiService apiService;
    private static RetrofitManager retrofitManager;

    public Map<Object, Object> info = new HashMap<>();
    public StringBuilder output = new StringBuilder();

    private String imeicode;
    private int distance, time;
    private double minSpeed, maxSpeed;

    public AipaoClinet(String imeicode) {
        super();
        this.imeicode = imeicode;
        selectAPI(imeicode);
    }

    private static void selectAPI(String imeicode) {

        try {
            retrofitManager = new RetrofitManager("http://client3.aipao.me/api/");
            apiService = retrofitManager.getApiService();
            LoginBean TestResult = apiService.imeilogin("Login_AndroidSchool", imeicode).execute().body();

            if (!Objects.requireNonNull(TestResult).isSuccess()) {
                retrofitManager = new RetrofitManager("http://client3.aipao.me/api/");
                apiService = retrofitManager.getApiService();
            }

        }catch (Exception e) {
            System.out.println("IMEICode has overdue");
        }

    }

    public void login() throws IOException {
        String apiUrl = retrofitManager.getRetrofit().baseUrl().toString();
        Call<LoginBean> loginBeanCall;

        loginBeanCall = apiService.imeilogin("LoginSchool", imeicode);
        LoginBean loginBean = loginBeanCall.execute().body();

        System.out.println(loginBeanCall.request());
        info.put("token", loginBean.getData().getToken());
        info.put("userId", loginBean.getData().getUserId());
        output.append(imeicode);
        output.append(", Login: ").append(loginBean.toString());
        System.out.println(output.toString());
    }

    public void getBasicInfo() throws IOException {
        Call<InfoBean> infoBeanCall = apiService.getinfo(info.get("token").toString());
        InfoBean infoBean = infoBeanCall.execute().body();

        distance = Objects.requireNonNull(infoBean).getData().getSchoolRun().getLengths();
        minSpeed = infoBean.getData().getSchoolRun().getMinSpeed();
        maxSpeed = infoBean.getData().getSchoolRun().getMaxSpeed();

        System.out.println(infoBeanCall.request());
        output = new StringBuilder();
        output.append(infoBean.toString());
        System.out.println(output.toString());
    }

    public void running() throws IOException {
        Map<String, String> locationmap = new HashMap<>();
        locationmap.put("S1", "40.62825");
        locationmap.put("S2", "120.79107");
        locationmap.put("S3", String.valueOf(distance));
        distance = randomUtils(distance, distance + 5);
        time = randomUtils(distance / ((maxSpeed + minSpeed) / 2), distance / minSpeed);

        Call<RunningInfoBean> running = apiService.startRunning(info.get("token").toString(), locationmap);
        RunningInfoBean RunningInfoBean = running.execute().body();
        info.put("runid", Objects.requireNonNull(RunningInfoBean).getData().getRunId());

        System.out.println(running.request());
//        output = new StringBuilder();
        output.append(String.format("Time Scope: [%.1f, %.1f]", distance / maxSpeed, distance / minSpeed))
                .append(String.format("%nRunning Distance: %s(��), Cost Time: %s(��)%n", distance, time));
        System.out.println(output.toString());
    }

    public void uploadRecord() throws IOException {
        Map<String, String> record = new HashMap<>();
        record.put("S1", info.get("runid").toString());// �����ܲ���¼��id
        record.put("S4", encrypt(time));// �ܲ�ʱ�� s
        record.put("S5", encrypt(distance));// �ܲ����� m
        record.put("S6", "A0A2A1A3A0");// �ܲ��ؼ��� ����: A0A2A1A3A0
        record.put("S7", "1");// �����ܲ���״̬ 1��ʾ�ɹ���0��2�ȷ�1ֵ��ʾʧ��
        record.put("S8", "xfvdmyirsg");// ����ԭ�ֶ�
        record.put("S9", encrypt(randomUtils(1111, 1888)));// �ܲ�����

        Call<UploadBean> uploadRecord = apiService.uploadRecord(info.get("token").toString(), record);
        System.out.println(info.toString());
        System.out.println(Objects.requireNonNull(uploadRecord.execute().body()).getData());
    }

}
