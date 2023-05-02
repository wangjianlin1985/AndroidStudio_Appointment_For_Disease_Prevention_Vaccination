package com.lewis.base.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.base.entity.ComResult;
import com.lewis.base.entity.Doctor;
import com.lewis.base.entity.User;
import com.lewis.base.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    //所有的
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public ComResult<List<User>>  getAllUser(){
        List<User> list = userMapper.selectAll();
        ComResult<List<User>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }
    //用户信息
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public ComResult<User>  getUserInfo(int id){
        User user = userMapper.selectByPrimaryKey(id);
        ComResult<User> result = new ComResult<>();
        result.setCode(0);

        result.setData(user);
        result.setMsg("success");
        return result;
    }
    //修改用户信息
    @RequestMapping(value = "/upUser",method = RequestMethod.POST)
    public ComResult  upUser(String name,String pwd,String img,Integer id,String sex,Integer age) throws Exception {

        ComResult result = new ComResult<>();
            User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            user.setSex(sex);
            user.setImg(img);
            user.setAge(age);
            user.setId(id);

            int i = userMapper.updateByPrimaryKey(user);


            if (i==1){
                result.setMsg("修改成功");

            }else {
                result.setMsg("faile");
            }
            result.setCode(0);

            return result;



    }
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ComResult  login(String account,String pwd) throws Exception {
        User user=new User();
        user.setAccount(account);
        user.setPwd(pwd);

        User user1 = userMapper.login(user);
        ComResult result = new ComResult<>();

        if (user1!=null){

            result.setMsg("登录成功");
            result.setData(user1);
            result.setCode(0);

            return result;
        }else {
            result.setMsg("账号或者密码不正确");

            result.setCode(0);

            return result;
        }


    }
    //注册
  @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ComResult  register(String account,String pwd) throws Exception {
      User user=new User();
      user.setAccount(account);
      user.setPwd(pwd);

      User user1 = userMapper.check(user);
      ComResult result = new ComResult<>();

      if (user1!=null){

          result.setMsg("账号已存在");

          result.setCode(0);

          return result;
      }else {
          int i = userMapper.insert(user);
          if (i==1){
              result.setMsg("注册成功,请登录");

          }else {
              result.setMsg("注册失败");
          }
          result.setCode(0);

          return result;
      }


    }
    //删除用户
    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public ComResult  delUser(Integer id){
        int i = userMapper.deleteByPrimaryKey(id);
        ComResult result = new ComResult<>();
          if (i==1){
              result.setMsg("success");
          }else {
              result.setMsg("faile");
          }
          result.setCode(0);

          return result;
      }




}
