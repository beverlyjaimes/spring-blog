package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

        ArrayList<Post> postsList;

    public PostController() {
        this.postsList = new ArrayList<Post>();

        postsList.add(new Post(1, "fist post", "new"));
        postsList.add(new Post(2, "second post", "Second post"));
    }

    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("posts", postsList.get((int)id - 1));
       return "posts/show";
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
    }
}
