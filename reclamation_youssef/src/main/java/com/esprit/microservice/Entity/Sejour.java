package com.esprit.microservice.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Sejour implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSejour;
	private String titre;
    private Date datedepart;
    private Date dateArrive;
    private int prix ;
    private String image;
    
    
    public Sejour() {
		super();
	}
    
    
    
	public Sejour(int idSejour, String titre, Date datedepart, Date dateArrive, int prix, String image) {
		super();
		this.idSejour = idSejour;
		this.titre = titre;
		this.datedepart = datedepart;
		this.dateArrive = dateArrive;
		this.prix = prix;
		this.image = image;
	}
	
    
    
    
    
	public int getIdSejour() {
		return idSejour;
	}
	public void setIdSejour(int idSejour) {
		this.idSejour = idSejour;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDatedepart() {
		return datedepart;
	}
	public void setDatedepart(Date datedepart) {
		this.datedepart = datedepart;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Sejour [idSejour=" + idSejour + ", titre=" + titre + ", datedepart=" + datedepart + ", dateArrive="
				+ dateArrive + ", prix=" + prix + ", image=" + image + "]";
	}

	
	
	
	
    
    
    

	
}
