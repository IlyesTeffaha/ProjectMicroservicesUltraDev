package com.esprit.microservices.entities;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="blog")
public class Blog {

    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPost;




    private String title;
    private String description;


    private LocalDateTime creationtime = LocalDateTime.now();


    private String Author;
    private String image;



  /*  public Candidat(String prenom) {
        super();
        this.prenom = prenom;
    }*/

    public Blog() {
        super();
    }

    public Blog(int idPost, String title, String description, LocalDateTime creationtime, String author, String image) {
        this.idPost = idPost;
        this.title = title;
        this.description = description;
        this.creationtime = creationtime;
        Author = author;
        this.image = image;
    }

    public Blog(String title) {
        this.title = title;
    }
    public LocalDateTime getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(LocalDateTime creationtime) {
        this.creationtime = creationtime;
    }


    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }






}
