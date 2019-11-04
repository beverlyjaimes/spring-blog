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
    public String add(@PathVariable int a, @PathVariable int b) {
        int total = a + b;
        return String.valueOf(total);
    }

    @RequestMapping(path = "/subtract/{a}/from/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int a, @PathVariable int b) {
        return Integer.toString(a - b);
    }

    @RequestMapping(path = "/multiply/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(a * b);
    }

    @RequestMapping(path = "/divide/{a}/by/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable double a, @PathVariable double b) {
        double total = a / b;
        return String.valueOf(total);
    }

}

