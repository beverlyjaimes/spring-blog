package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hey";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHelloWithName(@PathVariable String name){
        System.out.println("name = " + name);
        return "<h2>hey " + name + "</h2>";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
}

