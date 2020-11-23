package com.colourful.dsg.controller;

import com.colourful.dsg.feignClients.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Version
 * @Date 11/23/2020
 * @Author Gon
 */
@Controller
@RefreshScope
public class TestController
{
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProviderClient providerClient;
    @Value("${username:lily}")
    private String username;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/consumer", method = {RequestMethod.GET, RequestMethod.POST})
    public String consumer()
    {
        return restTemplate.getForObject("http://nacos-provider/testController?name=resttemplate",String.class);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/consumer2", method = {RequestMethod.GET, RequestMethod.POST})
    public String consumer2()
    {
        return providerClient.hi("feign");
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/username", method = {RequestMethod.GET, RequestMethod.POST})
    public String get() {
        return username;
    }
}
