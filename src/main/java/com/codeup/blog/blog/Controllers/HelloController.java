package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hey";
    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHelloWithName(@PathVariable String name){
//        System.out.println("name = " + name);
//        return "<h2>hey " + name + "</h2>";
//    }


    @GetMapping("/hello/{name}")
    public String sayHelloWithName(@PathVariable String name, Model viewModel){
        viewModel.addAttribute("name", name);
        return "hello";
//hello is the name of the file
    }


    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model vModel) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Mark");
        students.add("Beth");
        students.add("Eddy");


        vModel.addAttribute("cohort", "Welcome to " + cohort + "!");
        vModel.addAttribute("students", students);
        return "join";

//        model means nothing you can name it whatever you want but its not the MVC model.




    }
}

