package com.esprit.microservices.repositories;

import com.esprit.microservices.entities.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Query("select b from Blog b where b.title like :title")
    public Page<Blog> blogByTitle(@Param("title") String n, Pageable pageable);



    @Query("SELECT f from Blog f order by f.title desc ")
    List<Blog> retrieveAllBlogsByTitleDesc();

    @Query("select f from Blog f order by f.title asc")
    List<Blog> retrieveAllBlogsByTitleAsc();


    @Query("SELECT f from Blog f order by f.creationtime desc ")
    List<Blog> retrieveAllBlogsByCreationtimeDesc();

    @Query("select f from Blog f order by f.creationtime asc")
    List<Blog> retrieveAllBlogsByCreationtimeAsc();

}
