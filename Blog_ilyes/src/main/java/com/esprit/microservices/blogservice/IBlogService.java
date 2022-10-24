package com.esprit.microservices.blogservice;

import com.esprit.microservices.entities.Blog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IBlogService {



    Blog addBlog(Blog h);


    Blog updateBlog(int id, Blog s);
    void deleteBlog(int id);

    public List<Blog> retrieveAllblogs() ;







    List<Blog> retrieveAllBlogsByTitleDesc();

    List<Blog> retrieveAllBlogsByTitleAsc();

    List<Blog> retrieveAllBlogsByCreationtimeDesc();

    List<Blog> retrieveAllBlogsByCreationtimeAsc();



}
