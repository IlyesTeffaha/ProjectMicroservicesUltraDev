package com.esprit.microservice.Entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reclamation")
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReclamation;
    private String reclamationName;
    private String description;
    private Date date;
    private String image;
    private boolean inspected;

    public Reclamation() {
    }

    public Reclamation(int idReclamation, String reclamationName, String description, Date date, String image, boolean inspected) {
        this.idReclamation = idReclamation;
        this.reclamationName = reclamationName;
        this.description = description;
        this.date = date;
        this.image = image;
        this.inspected = inspected;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getReclamationName() {
        return reclamationName;
    }

    public void setReclamationName(String reclamationName) {
        this.reclamationName = reclamationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }
}
