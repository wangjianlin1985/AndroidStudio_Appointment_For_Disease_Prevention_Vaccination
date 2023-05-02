package com.lewis.base.controller;

import com.lewis.base.entity.ComResult;
import com.lewis.base.entity.Doctor;
import com.lewis.base.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    @Autowired
    DoctorMapper doctorMapper;

    //所有的
    @RequestMapping(value = "/getDoctors",method = RequestMethod.POST)
    public ComResult<List<Doctor>>  getDoctors(){
        List<Doctor> list = doctorMapper.selectAll();
        ComResult<List<Doctor>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }

    //用户信息
    @RequestMapping(value = "/getDoctorInfo",method = RequestMethod.POST)
    public ComResult<Doctor>  getDoctorInfo(int id){
        Doctor Doctor = doctorMapper.selectByPrimaryKey(id);
        ComResult<Doctor> result = new ComResult<>();
        result.setCode(0);

        result.setData(Doctor);
        result.setMsg("success");
        return result;
    }
    //修改用户信息
    @RequestMapping(value = "/upDoctor",method = RequestMethod.POST)
    public ComResult  upDoctor(String name,String pwd,String img,Integer id,String department,String position,String dec) throws Exception {

        ComResult result = new ComResult<>();
        Doctor Doctor = new Doctor();
        Doctor.setName(name);
        Doctor.setDepartment(department);
        Doctor.setDec(dec);
        Doctor.setImg(img);
        Doctor.setPwd(pwd);
        Doctor.setPosition(position);
        Doctor.setId(id);

        int i = doctorMapper.updateByPrimaryKey(Doctor);


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
        Doctor Doctor=new Doctor();
        Doctor.setAccount(account);
        Doctor.setPwd(pwd);

        Doctor Doctor1 = doctorMapper.login(Doctor);
        ComResult result = new ComResult<>();

        if (Doctor1!=null){

            result.setMsg("登录成功");
            result.setData(Doctor1);
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
        Doctor Doctor=new Doctor();
        Doctor.setAccount(account);
        Doctor.setPwd(pwd);

        Doctor Doctor1 = doctorMapper.check(Doctor);
        ComResult result = new ComResult<>();

        if (Doctor1!=null){

            result.setMsg("账号已存在");

            result.setCode(0);

            return result;
        }else {
            int i = doctorMapper.insert(Doctor);
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
    @RequestMapping(value = "/delDoctor",method = RequestMethod.POST)
    public ComResult  delDoctor(Integer id){
        int i = doctorMapper.deleteByPrimaryKey(id);
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
