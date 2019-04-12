package com.lijun.cloudredis.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @Author: liuguijun
 * @Desc:
 * @Date: 2019/4/11 14:32
 * @Version 1.0
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key,String value,Long time){
        if(StringUtils.isEmpty(key)){
            return;
        }
        if(time!=null){
            stringRedisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
        }else {
            stringRedisTemplate.opsForValue().set(key,value);
        }
    }


    public void setList(String key, List<String> list){
        if(StringUtils.isEmpty(key)){
            return;
        }
        for(String s : list){
            stringRedisTemplate.opsForList().leftPush(key,s);
        }
    }


    public void delKey(String key){
        stringRedisTemplate.delete(key);
    }


    public String getString(String key){
       return  stringRedisTemplate.opsForValue().get(key);
    }
}
