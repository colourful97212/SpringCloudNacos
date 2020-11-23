package com.colourful.dsg.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Version
 * @Date 11/23/2020
 * @Author Gon
 */
@FeignClient("nacos-provider")
public interface ProviderClient
{
    @RequestMapping(value = "/testController", method = {RequestMethod.POST})
    String hi(@RequestParam(value = "name", defaultValue = "forezp", required = false) String name);
}
