package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Post;
import com.codeup.blog.blog.Repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

//        ArrayList<Post> postsList;

    private final PostRepository postDao;


//    public PostController() {
//        this.postsList = new ArrayList<Post>();
//
//        postsList.add(new Post(1, "fist post", "new"));
//        postsList.add(new Post(2, "second post", "Second post"));
//    }

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model viewModel){
//        viewModel.addAttribute("posts", postsList);
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel){
//        viewModel.addAttribute("posts", postsList.get((int)id - 1));
        viewModel.addAttribute("posts", postDao.getOne(id));
       return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(){
        return "posts/create";
    }


    @PostMapping ("/posts/create")
    public String create(@RequestParam String title, @RequestParam String body){
        Post post = postDao.save(new Post(title, body));
        return "redirect:/posts/" + post.getId();
//    check to see if new constructor needs to be built
    }
    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String description) {
        Post oldPost = postDao.getOne(id);
        oldPost.setTitle(title);
        oldPost.setDescription(description);
//        oldPost.setDescription(description);
        oldPost.save(oldPost);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
