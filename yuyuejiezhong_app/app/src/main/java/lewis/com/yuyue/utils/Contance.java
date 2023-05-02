package lewis.com.yuyue.utils;

/**
 * Created by Administrator on 2019/5/15.
 */
//接口
public class Contance {
    //换成自己电脑ip
    public static  String BaseUrl="http://192.168.1.5:82";
    public static String Login=BaseUrl+"/user/login";//登录
    public static String Reg=BaseUrl+"/user/register";//注册
    public static String getUserInfo=BaseUrl+"/user/getUserInfo";//用户信息
    public static String upUserInfo=BaseUrl+"/user/upUser";//修改用户


    public static String docLogin=BaseUrl+"/doctor/login";//登录
    public static String docReg=BaseUrl+"/doctor/register";//注册
    public static String getdocInfo=BaseUrl+"/doctor/getDoctorInfo";//用户信息
    public static String updocInfo=BaseUrl+"/doctor/upDoctor";//修改用户
    public static String UpLoadPic=BaseUrl+"/upload";//上传头像


    public static String getDoctors=BaseUrl+"/doctor/getDoctors";//所有
    public static String pubKc=BaseUrl+"/kecheng/pubKc";//发布
    public static String upKc=BaseUrl+"/kecheng/upKc";//修改
    public static String delKc=BaseUrl+"/kecheng/delKc";//删除
    public static String getAllMyPubKeKeng=BaseUrl+"/kecheng/getAllMyPubKeKeng";//我发布的

    public static String getAllUser=BaseUrl+"/user/getAllUser";//学生

    public static String daFen=BaseUrl+"/mark/pubMark";//打分

    public static String getNews=BaseUrl+"/news/getNews";//
    public static String getAllRoom=BaseUrl+"/room/getAllRoom";
    public static String getAllMark=BaseUrl+"/mark/getAllMark";

    public static String getAppointById=BaseUrl+"/appointment/getAppointById";
    public static String addAppointment=BaseUrl+"/appointment/addAppointment";
    public static String delAppointment=BaseUrl+"/appointment/delAppointment";
    public static String getMyChat=BaseUrl+"/chat/getMyChat";
    public static String addChat=BaseUrl+"/chat/addChat";
    public static String addSession=BaseUrl+"/chat/addSession";
    public static String getMySession=BaseUrl+"/chat/getMySession";



}
