package com.liaoguoyin.aipao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class AipaoClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        int pauseTime = 50000;// Sleep 50s when finishing the script.
        int okIMEICode = 0;
        System.out.println("LGY ̫ǿ�ˣ�loading IMEICode.txt..");

        File file = new File("IMEICode.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        String IMEICodesText = readToString(file);
        String[] IMEICodes = IMEICodesText.split("\n");
        for (String each : IMEICodes) {
            each = each.split("-", 2)[0];
            if (running(each)) {
                okIMEICode = okIMEICode + 1;
            }
        }
        System.out.println("Total:" + IMEICodes.length + ", Success: " + okIMEICode);
        System.out.println("AipaoCli will exit in 50s..");
        Thread.sleep(pauseTime);
    }

    private static Boolean running(String imeiCode) {
        try {
            AipaoClinet clinet = new AipaoClinet(imeiCode);
            clinet.login();
            clinet.getBasicInfo();
            clinet.running();
            clinet.uploadRecord();

            System.out.println("Success: http://sportsapp.aipao.me/Manage/UserDomain_SNSP_Records.aspx/MyResutls?userId=" + clinet.info.get("userId").toString());
            File file = new File("output.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(clinet.output.toString());
            fileWriter.close();
            return Boolean.TRUE;

        }catch (IOException e) {
            System.out.println("��������쳣������ű��Ƿ��ж�дȨ��");
            e.printStackTrace();
            return Boolean.FALSE;
        }catch (NullPointerException e) {
            System.out.println(imeiCode + " ��ָ���쳣��������IMEICodeʧЧ");
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }


    private static String readToString(File file) {
        long filelength = file.length();
        byte[] filecontent = new byte[(int) filelength];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(filecontent);
            fileInputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return new String(filecontent);
    }

}
