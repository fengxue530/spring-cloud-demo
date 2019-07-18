package com.fx.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: mabaofeng
 * @date: 2019/7/18 15:47
 * @description:
 */
@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${name}")
    private String userName;

    @Value("${password}")
    private String password;

    @RequestMapping("/test")
    public Object getRemoteConfigByValue(){
        Map<String,Object> model=new HashMap<>();
        model.put("getMode","@Value");

        Map<String,String> remoteCgfMap=new HashMap<>();
        remoteCgfMap.put("clientUserName", userName);
        remoteCgfMap.put("clientPassword", password);
        model.put("remoteConfig",remoteCgfMap);
        return model;
    }
}
