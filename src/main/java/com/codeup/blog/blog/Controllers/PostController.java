package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Post;
import com.codeup.blog.blog.PostDetails;
import com.codeup.blog.blog.PostImage;
import com.codeup.blog.blog.Repositories.ImageRepo;
import com.codeup.blog.blog.Repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.awt.*;
import java.util.List;


@Controller
public class PostController {


    private final PostRepository postDao;
    private final ImageRepo imageDao;


    public PostController(PostRepository postDao, ImageRepo imageDao) {
        this.postDao = postDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
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
    public String showCreateForm() {
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String create(@RequestParam String title, @RequestParam String body) {
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

    @GetMapping("/posts/update/{id}")
    public String updateDetails(@PathVariable long id, @RequestParam String details) {

        Post post = postDao.getOne(id);
        PostDetails pd = post.getPostDetails();
        pd.setDetailsDescription(details);
        post.setPostDetails(pd);

        postDao.save(post);

        return "redirect:/posts/historyOfPosts";
    }

    @GetMapping("/posts/{id}/historyOfPosts")
    public String getHistoryOfPost(@PathVariable long id, Model vModel) {

        Post post = postDao.getOne(id);

        vModel.addAttribute("post", post);

        return "posts/historyOfPosts";
    }


//    one to many

    @PostMapping("/posts/{id}/add-image")
    public String addImage(
            @PathVariable long id,
            @RequestParam String image_title,
            @RequestParam String url) {


        PostImage image = new PostImage(image_title, url);
        image.setPost(postDao.getOne(id));
        imageDao.save(image);

        return "redirect:/posts";

    }
}





