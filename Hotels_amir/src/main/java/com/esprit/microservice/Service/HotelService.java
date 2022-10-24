package com.esprit.microservice.Service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.esprit.microservice.Entity.Hotel;
import com.esprit.microservice.Repository.HotelRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service

public class HotelService implements IHotelService {

	@Autowired
	private HotelRepository hotelRepository; 
	@Autowired
    ServletContext context;
	
	
	
	
	@Override
	public ResponseEntity<Response> addHotel(Hotel h) throws JsonParseException, JsonMappingException, Exception {
		// TODO Auto-generated method stub
		 Hotel hotel = hotelRepository.save(h);



	        if (hotel != null)
	        {
	            return new ResponseEntity<Response>( HttpStatus.OK);
	        }
	        else
	        {
	            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
	        }
	}
	@Override
	public ResponseEntity<Response> updateHotel(int id, Hotel h) throws JsonParseException, JsonMappingException, Exception {
		 Hotel hotel = hotelRepository.findById(id).get();
		 if (hotel != null)
	        {
			 	hotelRepository.save(h);
	            return new ResponseEntity<Response>( HttpStatus.OK);
	        }
	        else
	        {
	        	hotelRepository.save(hotel);
	            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
	        }
		
	}
	@Override
	public void  deleteHotel(int id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
	}
	
	
	@Override
	public List<Hotel> retrieveAllhotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}
	/*****************************************************************************************************/
	@Override
	public List<Hotel> retrieveAllHotelByName(String name) {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelByName(name);
	}
	@Override
	public List<Hotel> retrieveAllHotelBystate(String state) {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelBystate(state);
	}
	@Override
	public List<Hotel> retrieveAllHotelByNameHotelDesc() {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelByNameHotelDesc();
	}
	@Override
	public List<Hotel> retrieveAllHotelByNameHotelAsc() {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelByNameHotelAsc();
	}
	@Override
	public Hotel retrieveHotelById(Long idHotel) {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveHotelById(idHotel);
	}
	@Override
	public List<Hotel> retrieveAllHotelByPriceAsc() {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelByPriceAsc();
	}
	@Override
	public List<Hotel> retrieveAllHotelByPriceDesc() {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelByPriceDesc();
	}
	@Override
	public List<Hotel> retrieveAllHotelBetweenPrices(float min, float max) {
		// TODO Auto-generated method stub
		return hotelRepository.retrieveAllHotelBetweenPrices(min, max);
	}
	
	
	
	
	
	
	
	

	

	
	
	
	
	

}
