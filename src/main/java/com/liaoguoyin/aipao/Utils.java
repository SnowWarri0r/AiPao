package com.liaoguoyin.aipao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    /**
     * ����һ��һ����Χ[min, max]�����ط�Χ�ڵ������
     *
     * @param min ���������Сֵ
     * @param max ����������ֵ
     * @return ���ط�Χ�ڵ������
     */
    static int randomUtils(int min, int max) {
        return (int) (min + ((max - min) * Math.random()));
    }

    static int randomUtils(double min, double max) {
        return (int) (min + ((max - min) * Math.random()));
    }

    /**
     * ������ת������ĸ�������ʱ��ͬ���ֶ�Ӧ����ĸΨһ
     *
     * @param i ��ת����
     * @return ���ܴ������ַ���
     */
    static String encrypt(int i) {
        String encryptOrigin = "xfvdmyirsg";// ����10����ͬ���ַ�������Դ(ע�⣡��������ȫ���⣬��Ҫ�Լ�ץһ�ΰ���ȷ��)
        StringBuilder result = new StringBuilder();
        char[] chars = String.valueOf(i).toCharArray();

        for (char each : chars) {
            result.append(encryptOrigin.charAt(each - '0'));
        }
        return result.toString();
    }

    /**
     * @param s inputstring
     * @return ���ض�Ӧ��md5ֵ
     * @throws NoSuchAlgorithmException md5�㷨����
     */
    public static String md5(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        messageDigest.update(s.getBytes());
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
