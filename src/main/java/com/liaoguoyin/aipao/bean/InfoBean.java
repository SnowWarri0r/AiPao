package com.liaoguoyin.aipao.bean;


import java.util.HashMap;
import java.util.Map;

public class InfoBean {

    /**
     * Success : true
     * Data : {"User":{"UserID":396971,"NickName":"LGY","UserName":"1710030212","Sex":"��","Province":null,"City":null,"Country":null,"HeadImgUrl":"","Mobile":null,"MobileVerifyCode":null,"IsMoblileVerify":"0","Weights":0,"BMI":0,"Heights":0,"Birthday":"0001-01-01 00:00:00","OldYears":0,"IsInfoOk":"0","WXNickName":null,"WXSex":null,"IsStationOpen":"0","IsBgMusic":"1","IsReciveMsg":"1","IsSchoolMode":"1","Level_Lengh":0,"Level_Lengh_Date":"2015-01-01 00:00:00","Days_Start":0,"Days_Start_Date":"2015-01-01 00:00:00"},"SchoolRun":{"Sex":"��","SchoolId":"lntu","SchoolName":"�������̼�����ѧ","MinSpeed":1.9,"MaxSpeed":4,"Lengths":3000,"IsNeedPhoto":"0","IsShowAd":0}}
     */

    private boolean Success;
    private DataBean Data;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    /**
     * @return ����һЩ�м�ֵ����Ϣ
     */
    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>();
        map.put("����", this.getData().User.NickName);
        map.put("ѧУ", this.getData().SchoolRun.SchoolName);
        map.put("ѧ��", this.getData().User.UserName);
        map.put("�Ա�", this.getData().SchoolRun.Sex);
        map.put("��С�ٶ�", this.getData().SchoolRun.MinSpeed);
        map.put("����ٶ�", this.getData().SchoolRun.MaxSpeed);
        map.put("�ܲ�·��", this.getData().SchoolRun.Lengths);
        return map.toString();
    }

    public static class DataBean {
        /**
         * User : {"UserID":396973,"NickName":"LGY","UserName":"1710030205","Sex":"��","Province":null,"City":null,"Country":null,"HeadImgUrl":"","Mobile":null,"MobileVerifyCode":null,"IsMoblileVerify":"0","Weights":0,"BMI":0,"Heights":0,"Birthday":"0001-01-01 00:00:00","OldYears":0,"IsInfoOk":"0","WXNickName":null,"WXSex":null,"IsStationOpen":"0","IsBgMusic":"1","IsReciveMsg":"1","IsSchoolMode":"1","Level_Lengh":0,"Level_Lengh_Date":"2015-01-01 00:00:00","Days_Start":0,"Days_Start_Date":"2015-01-01 00:00:00"}
         * SchoolRun : {"Sex":"��","SchoolId":"lntu","SchoolName":"�������̼�����ѧ","MinSpeed":1.9,"MaxSpeed":4,"Lengths":3000,"IsNeedPhoto":"0","IsShowAd":0}
         */

        private UserBean User;
        private SchoolRunBean SchoolRun;

        public UserBean getUser() {
            return User;
        }

        public void setUser(UserBean User) {
            this.User = User;
        }

        public SchoolRunBean getSchoolRun() {
            return SchoolRun;
        }

        public void setSchoolRun(SchoolRunBean SchoolRun) {
            this.SchoolRun = SchoolRun;
        }

        public static class UserBean {
            /**
             * UserID : 396974
             * NickName : LGY
             * UserName : 1710030211
             * Sex : ��
             * Province : null
             * City : null
             * Country : null
             * HeadImgUrl :
             * Mobile : null
             * MobileVerifyCode : null
             * IsMoblileVerify : 0
             * Weights : 0
             * BMI : 0
             * Heights : 0
             * Birthday : 0001-01-01 00:00:00
             * OldYears : 0
             * IsInfoOk : 0
             * WXNickName : null
             * WXSex : null
             * IsStationOpen : 0
             * IsBgMusic : 1
             * IsReciveMsg : 1
             * IsSchoolMode : 1
             * Level_Lengh : 0
             * Level_Lengh_Date : 2015-01-01 00:00:00
             * Days_Start : 0
             * Days_Start_Date : 2015-01-01 00:00:00
             */

            private int UserID;
            private String NickName;
            private String UserName;
            private String Sex;

            public int getUserID() {
                return UserID;
            }

            public void setUserID(int UserID) {
                this.UserID = UserID;
            }

            public String getNickName() {
                return NickName;
            }

            public void setNickName(String NickName) {
                this.NickName = NickName;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getSex() {
                return Sex;
            }

            public void setSex(String Sex) {
                this.Sex = Sex;
            }
        }

        public static class SchoolRunBean {
            /**
             * Sex : ��
             * SchoolId : lntu
             * SchoolName : �������̼�����ѧ
             * MinSpeed : 1.9
             * MaxSpeed : 4
             * Lengths : 3000
             * IsNeedPhoto : 0
             * IsShowAd : 0
             */

            private String Sex;
            private String SchoolId;
            private String SchoolName;
            private double MinSpeed;
            private double MaxSpeed;
            private int Lengths;

            public String getSex() {
                return Sex;
            }

            public void setSex(String Sex) {
                this.Sex = Sex;
            }

            public String getSchoolId() {
                return SchoolId;
            }

            public void setSchoolId(String SchoolId) {
                this.SchoolId = SchoolId;
            }

            public String getSchoolName() {
                return SchoolName;
            }

            public void setSchoolName(String SchoolName) {
                this.SchoolName = SchoolName;
            }

            public double getMinSpeed() {
                return MinSpeed;
            }

            public void setMinSpeed(double MinSpeed) {
                this.MinSpeed = MinSpeed;
            }

            public double getMaxSpeed() {
                return MaxSpeed;
            }

            public void setMaxSpeed(int MaxSpeed) {
                this.MaxSpeed = MaxSpeed;
            }

            public int getLengths() {
                return Lengths;
            }

            public void setLengths(int Lengths) {
                this.Lengths = Lengths;
            }
        }
    }
}
