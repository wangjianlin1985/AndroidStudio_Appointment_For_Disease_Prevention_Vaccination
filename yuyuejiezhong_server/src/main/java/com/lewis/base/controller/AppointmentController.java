package com.lewis.base.controller;


import com.lewis.base.entity.*;
import com.lewis.base.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
    @Autowired
    AppointmentMapper appointmentMapper;

    //
    @RequestMapping(value = "/getAppointById",method = RequestMethod.POST)
    public ComResult<List<Appointment>> getAppointById(Integer uid){


        List<Appointment> appointments = appointmentMapper.selectAll();
        List<Appointment> appointmentList = new ArrayList<>();

        for (int i = 0; i <appointments.size() ; i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getUid()==uid){
                appointmentList.add(appointment);
            }

        }
        ComResult<List<Appointment>> result = new ComResult<>();
        result.setMsg("sucess");
        result.setCode(0);
        result.setData(appointmentList);
        return result;
    }

    //添加
    @RequestMapping(value = "/addAppointment",method = RequestMethod.POST)
    public ComResult addAppointment(Integer uid,String ctime,String type){
        Appointment Appointment = new Appointment();
        Appointment.setCtime(ctime);
        Appointment.setType(type);
        Appointment.setUid(uid);
        ComResult result = new ComResult<>();
        int insert = appointmentMapper.insert(Appointment);


            if (insert==1){
                result.setMsg("预约成功");

            }else {
                result.setMsg("faile");

            }

        result.setCode(0);
        return result;
    }



    //取消
    @RequestMapping(value = "/delAppointment",method = RequestMethod.POST)
    public ComResult delAppointment(Integer id){

        int insert = appointmentMapper.deleteByPrimaryKey(id);
        ComResult result = new ComResult<>();
        if (insert==1){
            result.setMsg("删除成功");

        }else {
            result.setMsg("faile");

        }

        result.setCode(0);

        return result;
    }




}
