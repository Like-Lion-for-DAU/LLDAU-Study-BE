package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String HelloMethod(){
        return "Hello, LikeLion!";
    }


    @GetMapping("/hello/{name}")
    public String NameMethod(@PathVariable("name") String name){
        return "Hello, "+name;
    }

}
