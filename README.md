# 原作者已经弃坑

**这里只是目前进行了小部分改动，以满足个人需求（以后看个人需求与发展会进行相应更新）**

**注意：这里只支持安卓**

More: [阳光体育长跑的正确打开姿势](https://liaoguoyin.com/2019/05/19/Aipao.html)

## Preview

![Aipao - UI](AipaoTest.gif)

![Aipao - final version](finalTest.gif)

## Usage

#### 1. 获取 IMEICode
  - 打开抓包软件, 再打开阳光体育APP, 在抓包软件中找后缀有 `IMEICode= ` 的URL请求, 等号后面的字段即 `IMEICode`
   
  - (若多次抓不到: 来回切换几次飞行模式, 再打开阳光体育)
    
#### 2. 运行
  - 点击本页面的 `realease` 
  
  - 下载压缩包并解压, 双击 `start.bat` (mac命令行下: `bash start.bat`)
  
  - 看到输入提示后, 粘贴 `Imeicode` 即可 (每跑一次，会在本地 output.txt 生成一行记录)
  
## Todo(原作者的，以后说不定会把这个TODO最后完成)
   - [x] 判断性别, 随机生成相应的时间、路程
   - [x] 每操作一步，返回提示
   - [x] 错误提示
   - [X] UI
   - [x] 批量
   - [ ] 请求中添加加密 headers
 
## Recommend Capture App

   Android: Packet Capture
   
## Design it by Youself
   - Star 本项目（球球你给我 Star 8）
   
   - 下载后 IDEA 打开项目, 然后 import Gradle project.
 
   - 进入 [src/test](src/test/java/com/liaoguoyin/aipao/AipaoClientTest.java) 目录, 点击左侧的绿色箭头运行, 在控制台输入 `IMEICode` 回车即可.
 
   
## Other
     **Author: [LiaoGuoYin](https://github.com/Biubang)**

     **基于HTTP框架: [Retrofit2](https://square.github.io/retrofit/)**  
     
     **核心API出自: [zyc199847](https://github.com/zyc199847/Sunny-Running) 逆向成果**
   
     **License GPL v3.0**

## Warning
     本文仅供研究，使用者造成的任何后果由使用者自行承担，与作者无关。
   
