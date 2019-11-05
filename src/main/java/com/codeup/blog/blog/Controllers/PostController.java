package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

//    @GetMapping("/posts")
//    @ResponseBody
//    public String posts(){
//        return "posts index page";
//    }

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

    @GetMapping("/post")
    public String individualPost(Model viewModel){
        ArrayList<Post> postsList = new ArrayList<Post>();
        postsList.add(new Post(1, "fist post", "new"));

        viewModel.addAttribute("posts", postsList);


        return "posts/show";
    }

    @GetMapping("/posts")
    public String allPosts(Model viewModel){
        ArrayList<Post> postsList = new ArrayList<Post>();
        postsList.add(new Post(1, "fist post", "new"));
        postsList.add(new Post(2, "second post", "Second post"));


        viewModel.addAttribute("posts", postsList);


        return "posts/index";
    }
}
