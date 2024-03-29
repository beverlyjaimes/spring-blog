package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Services.EmailService;
import com.codeup.blog.blog.Post;
import com.codeup.blog.blog.Repositories.PostRepository;
import com.codeup.blog.blog.Repositories.UserRepository;
import com.codeup.blog.blog.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class PostController {


    private final PostRepository postDao;
    private final UserRepository userDao;

    @Autowired
    EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
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
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }


@PostMapping("/posts/create")
public String create(@ModelAttribute Post postToBeCreated) {
    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    postToBeCreated.setUser(currentUser);
    Post savePost = postDao.save(postToBeCreated);
    emailService.prepareAndSend(postToBeCreated, "Post created", "A post has been created with the id of " + postToBeCreated.getId());
    return "redirect:/posts/" + savePost.getId();
}

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @ModelAttribute Post post) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(currentUser);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }



    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }



}
