package lewis.com.yuyue.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/3/17.
 */

public class DocList implements Serializable{

    /**
     * code : 0
     * msg : sucess
     * count : 0
     * data : [{"id":2,"name":"计算机","time":"18:00-19:00","zhou":"1-20周","type":"公选课","pId":1,"num":34}]
     */

    public int code;
    public String msg;
    public int count;
    public List<DataBean> data;


    public static class DataBean implements Serializable{


        public int id;
        public String name;
        public String department;
        public String position;
        public String dec;
        public String img;
        public String account;
        public String pwd;



    }
}
