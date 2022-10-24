package com.esprit.microservices.blogservice;
import com.esprit.microservices.entities.Blog;

import com.esprit.microservices.repositories.BlogRepository;

import java.util.List;

import javax.ws.rs.core.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;


    public Blog addBlog(Blog b) {
        // TODO Auto-generated method stub
        return blogRepository.save(b);


    }
    public Blog updateBlog(int id, Blog h)  {
        Blog blog = blogRepository.findById(id).get();
        return blogRepository.save(h);

    }

    public void  deleteBlog(int id) {
        // TODO Auto-generated method stub
        blogRepository.deleteById(id);
    }



    public List<Blog> retrieveAllblogs() {
        // TODO Auto-generated method stub
        return blogRepository.findAll();
    }
    /*****************************************************************************************************/
/*
    public List<Blog> blogByTitle(String title) {
        // TODO Auto-generated method stub
        return (List<Blog>) blogRepository.blogByTitle(title);
    }*/


    public List<Blog> retrieveAllBlogsByTitleDesc() {
        // TODO Auto-generated method stub
        return blogRepository.retrieveAllBlogsByTitleDesc();
    }

    public List<Blog> retrieveAllBlogsByTitleAsc() {
        // TODO Auto-generated method stub
        return blogRepository.retrieveAllBlogsByTitleAsc();
    }

    public List<Blog> retrieveAllBlogsByCreationtimeDesc() {
        // TODO Auto-generated method stub
        return blogRepository.retrieveAllBlogsByCreationtimeDesc();
    }

    public List<Blog> retrieveAllBlogsByCreationtimeAsc() {
        // TODO Auto-generated method stub
        return blogRepository.retrieveAllBlogsByCreationtimeAsc();
    }

}
