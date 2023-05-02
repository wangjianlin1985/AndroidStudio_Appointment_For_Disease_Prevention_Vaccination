package lewis.com.yuyue.bean;

import java.io.Serializable;

/**
 * Created by Ad
 */
//用户实体
public class Login implements Serializable{


    /**
     * code : 0
     * msg : 登录成功
     * count : 0
     * data : {"id":1,"type":"0","account":"2312312","pwd":"123456","name":"小王","img":"sssas","xueyaun":"计算机","banji":"三班"}
     */

    public int code;
    public String msg;
    public int count;
    public DataBean data;



    public static class DataBean implements Serializable{
        /**
         * id : 1
         * type : 0
         * account : 2312312
         * pwd : 123456
         * name : 小王
         * img : sssas
         * xueyaun : 计算机
         * banji : 三班
         */

        public int id;
        public String account;
        public String pwd;
        public String name;
        public String img;
        public String sex;
        public String age;


    }
}
