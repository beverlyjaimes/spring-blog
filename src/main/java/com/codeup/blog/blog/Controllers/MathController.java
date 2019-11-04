package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int a, @PathVariable int b) {

        return a + b ;
    }
}

