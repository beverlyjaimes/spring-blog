package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "view an individual post id = " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostForm(){
        return "view the form for creating a post";
    }

    @PostMapping ("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title, @RequestParam String body){
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        return "create a new post";
//        RequestParam
//        shift test reset
    }
}
