package com.esprit.microservice.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Sejour implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSejour;
	private String titre;
	@Temporal(TemporalType.DATE)
    private Date datedepart;
	@Temporal(TemporalType.DATE)
    private Date dateArrive; 
    private int prix ;
    private String image;
    
    private boolean availability;
	private String description;
	private int currentCap;
	private int maxCap;
	private String clientId;

    
    public Sejour() {
		super();
	}
    
    
    
    
    
    
    
    
    
	









	public Sejour(int idSejour, String titre, Date datedepart, Date dateArrive, int prix, String image,
			boolean availability, String description, int currentCap, int maxCap, String clientId) {
		super();
		this.idSejour = idSejour;
		this.titre = titre;
		this.datedepart = datedepart;
		this.dateArrive = dateArrive;
		this.prix = prix;
		this.image = image;
		this.availability = availability;
		this.description = description;
		this.currentCap = currentCap;
		this.maxCap = maxCap;
		this.clientId = clientId;
	}



















	public boolean isAvailability() {
		return availability;
	}

















	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

















	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public int getCurrentCap() {
		return currentCap;
	}







	public void setCurrentCap(int currentCap) {
		this.currentCap = currentCap;
	}







	public int getMaxCap() {
		return maxCap;
	}







	public void setMaxCap(int maxCap) {
		this.maxCap = maxCap;
	}







	public String getClientId() {
		return clientId;
	}







	public void setClientId(String clientId) {
		this.clientId = clientId;
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
				+ dateArrive + ", prix=" + prix + ", image=" + image + ", availability=" + availability
				+ ", description=" + description + ", currentCap=" + currentCap + ", maxCap=" + maxCap + ", clientId="
				+ clientId + "]";
	}
	
	
	
	
	

	
	
	
	
    
    
    

	
}
