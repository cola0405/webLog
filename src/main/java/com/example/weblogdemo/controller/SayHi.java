package com.example.weblogdemo.controller;

import com.example.weblogdemo.annotation.WebLog;
import com.example.weblogdemo.entity.SayHiReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @version v1.0.0
 * @author cola
 * @date 2022/4/26
 */
@RestController
public class SayHi {

    @RequestMapping("/")
    @WebLog(action = "打招呼")
    String sayHi(@RequestBody SayHiReq req){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hi";
    }
}
