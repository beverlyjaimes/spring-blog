package com.codeup.blog.blog.Controllers;


import com.codeup.blog.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index(Model viewModel){
        return "home";
    }

}

