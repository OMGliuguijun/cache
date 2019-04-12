package com.lijun.cloudredis.web;

import com.lijun.cloudredis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuguijun
 * @Desc:
 * @Date: 2019/4/12 10:31
 * @Version 1.0
 */
@RestController
public class IndexController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/getKey")
    public String getKey(String key){
        return redisService.getString(key);
    }


    @RequestMapping("/setString")
    public String setString(){
        redisService.setString("liu","贵军",18639089376L);
        return "操作成功";
    }

    @RequestMapping("/delKey")
    public String delKey(String key){
        redisService.delKey(key);
        return "操作成功";
    }

    @RequestMapping("/test")
    public String test(){

        return "操作成功";
    }
}
