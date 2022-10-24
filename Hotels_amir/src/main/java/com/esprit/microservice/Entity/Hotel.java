package com.esprit.microservice.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="hotels")
public class Hotel implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idHotel;
	private String hotelName;
	private String description;
    private float prixParJour ;
    private String country;
    private String state;
    private String city;
    private String image;
    private int like;
    private int maxCap;
    private int currentCap;
    private boolean availability;
    
    
    public Hotel() {
		
	}


	private Hotel(int idHotel, String hotelName, String description, float prixParJour, String country, String state,
			String city, String image, int like, int maxCap, int currentCap, boolean availability) {
		super();
		this.idHotel = idHotel;
		this.hotelName = hotelName;
		this.description = description;
		this.prixParJour = prixParJour;
		this.country = country;
		this.state = state;
		this.city = city;
		this.image = image;
		this.like = like;
		this.maxCap = maxCap;
		this.currentCap = currentCap;
		this.availability = availability;
	}


	public int getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getPrixParJour() {
		return prixParJour;
	}


	public void setPrixParJour(float prixParJour) {
		this.prixParJour = prixParJour;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getLike() {
		return like;
	}


	public void setLike(int like) {
		this.like = like;
	}


	public int getMaxCap() {
		return maxCap;
	}


	public void setMaxCap(int maxCap) {
		this.maxCap = maxCap;
	}


	public int getCurrentCap() {
		return currentCap;
	}


	public void setCurrentCap(int currentCap) {
		this.currentCap = currentCap;
	}


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	


	
	
	
    
    
    
	

	
	
	
	
    
    
    

	
}