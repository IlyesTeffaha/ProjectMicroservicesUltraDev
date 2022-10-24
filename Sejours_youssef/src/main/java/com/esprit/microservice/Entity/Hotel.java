package com.esprit.microservice.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHotel;
	private String nom;
    private String image;
    private String description;
    private int prix ;


public Hotel(){
	
	super();
	
}










public Hotel(String nom) {
	super();
	this.nom = nom;
}










public Hotel(int idHotel, String nom, String image, String description, int prix) {
	super();
	this.idHotel = idHotel;
	this.nom = nom;
	this.image = image;
	this.description = description;
	this.prix = prix;
}

public int getIdHotel() {
	return idHotel;
}
public void setIdHotel(int idHotel) {
	this.idHotel = idHotel;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}

@Override
public String toString() {
	return "Hotel [idHotel=" + idHotel + ", nom=" + nom + ", image=" + image + ", description=" + description
			+ ", prix=" + prix + "]";
}




}
