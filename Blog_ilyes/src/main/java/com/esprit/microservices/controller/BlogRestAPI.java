package com.esprit.microservices.controller;

import com.esprit.microservices.blogservice.IBlogService;
import com.esprit.microservices.entities.Blog;
import  com.esprit.microservices.blogservice.BlogService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/blog")
@CrossOrigin
public class BlogRestAPI {

    private String title="Hello , I'm the candidate Microservice";

    @Autowired
    IBlogService blogService;

    @RequestMapping("/hello")
    public  String sayHello(){
        System.out.println(title);
        return title;
    };

    @GetMapping("/getblogs")
    @ResponseBody
    public List<Blog> getBlogs() {
        List<Blog> listB = blogService.retrieveAllblogs();
        return listB;
    }




    @PostMapping("/addblog")
    @ResponseBody
    public Blog addblog(@RequestBody Blog b){
        return blogService.addBlog(b);
    }
    @PutMapping("/updateblog")
    @ResponseBody
    public Blog updateblog(@RequestBody Blog b){
        return blogService.addBlog(b);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBlog(@PathVariable(value="id") int  id){
        blogService.deleteBlog(id);
    }

}
