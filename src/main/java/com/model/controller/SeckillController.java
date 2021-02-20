package com.model.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;


@Controller
@RequestMapping("ss")
public class SeckillController {



    Jedis jedis =new Jedis("192.168.140.128",6379);


    @PostMapping ("ab")
    public boolean ab(String uid,String prodid){

        String kckey = "Seckill:"+prodid+":kc";
        String userKey = "Seckill:"+prodid+"user";

        String kc = jedis.get(kckey);

        if(kc==null){
            System.out.println("尚未开始");
            jedis.close();
            return false;
        }

        if(jedis.sismember(userKey,uid)){
            System.out.println("不可重复购买");
            jedis.close();
            return false;
        }
        if(Integer.parseInt(kc)<=0){
            System.out.println("已结束");
            jedis.close();
            return false;
        }
        jedis.decr(kckey);
        jedis.sadd(userKey,uid);
        jedis.close();
        return true;
    }

//    ab -n 1000 -c 200 -p /opt/testFile/Seckill -T "application/x-www-form-urlencoded" 192.168.67.241:8080/ssmTest/ss/ab

}
