package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Post;
import com.codeup.blog.blog.Repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class PostController {


    private final PostRepository postDao;


    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
       return "posts/show";
    }

    @GetMapping("/posts/search")
    @ResponseBody
    public Post search() {
        return postDao.findByTitle("Gazella thompsonii");
    }

    @ResponseBody
    @GetMapping("/list-posts")
    public List<Post> returnPosts() {
        return postDao.findAll();
    }

    @ResponseBody
    @GetMapping("/posts/length")
    public List<String> returnPostsByLength() {
        return postDao.getPostsOfCertainTitleLength();
    }

    @ResponseBody
    @GetMapping("/posts/length/native")
    public List<String> returnPostsByLengthNative() {
        return postDao.getPostsOfCertainTitleLengthNative();
    }


    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "posts/create";
    }


    @PostMapping ("/posts/create")
    public String create(@RequestParam String title, @RequestParam String body){
        Post post = postDao.save(new Post(title, body));
        return "redirect:/posts/" + post.getId();
    }
    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post oldPost = postDao.getOne(id);
        oldPost.setTitle(title);
        oldPost.setBody(body);
        postDao.save(oldPost);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
