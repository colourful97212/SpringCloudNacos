package com.colourful.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Version
 * @Date 11/23/2020
 * @Author Gon
 */
@Controller
public class TestController
{
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/testController", method={RequestMethod.GET, RequestMethod.POST})
    public String testController(
            @RequestParam(value = "name", required = false) String name
    )
    {
        return "hello cloud " + name;
    }

}
