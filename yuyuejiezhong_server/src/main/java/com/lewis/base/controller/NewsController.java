package com.lewis.base.controller;

import com.lewis.base.entity.News;
import com.lewis.base.entity.ComResult;
import com.lewis.base.entity.Doctor;
import com.lewis.base.entity.News;
import com.lewis.base.mapper.DoctorMapper;
import com.lewis.base.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    NewsMapper newsMapper;

    //所有的
    @RequestMapping(value = "/getNews",method = RequestMethod.POST)
    public ComResult<List<News>>  getNews(){
        List<News> list = newsMapper.selectAll();
        ComResult<List<News>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }

    //添加
    @RequestMapping(value = "/addNews",method = RequestMethod.POST)
    public ComResult addNews(String content,String title){
        News News = new News();
        News.setCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        News.setContent(content);
        News.setTitle(title);
        ComResult result = new ComResult<>();
        int insert = newsMapper.insert(News);


        if (insert==1){
            result.setMsg("添加成功");

        }else {
            result.setMsg("faile");

        }

        result.setCode(0);
        return result;
    }
    //添加
    @RequestMapping(value = "/upNews",method = RequestMethod.POST)
    public ComResult upNews(String content,String title,Integer id){
        News News = new News();
        News.setCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        News.setContent(content);
        News.setTitle(title);
        News.setId(id);
        ComResult result = new ComResult<>();
        int insert = newsMapper.insert(News);

        if (insert==1){
            result.setMsg("更新成功");

        }else {
            result.setMsg("faile");

        }

        result.setCode(0);
        return result;
    }


    //取消
    @RequestMapping(value = "/delNews",method = RequestMethod.POST)
    public ComResult delNews(Integer uid){

        int insert = newsMapper.deleteByPrimaryKey(uid);
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
