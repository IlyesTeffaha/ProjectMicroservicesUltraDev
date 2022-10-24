package com.esprit.microservice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Hotel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IHotelService {
	
	
	
	
	ResponseEntity<Response> addHotel(Hotel h)
	throws JsonParseException, JsonMappingException, Exception;
	
	ResponseEntity<Response> updateHotel(int id, Hotel s) throws JsonParseException, JsonMappingException, Exception;
	void deleteHotel(int id);
	
	public List<Hotel> retrieveAllhotels() ;
	/*ResponseEntity<Response> addsejour(Sejour Sejour)
			throws JsonParseException, JsonMappingException, Exception;*/
	
	List<Hotel> retrieveAllHotelByName(String name);
	
    List<Hotel> retrieveAllHotelBystate( String location);

   
    List<Hotel> retrieveAllHotelByNameHotelDesc();

    List<Hotel> retrieveAllHotelByNameHotelAsc();

  
    Hotel retrieveHotelById(Long idHotel);
    
    
    List<Hotel> retrieveAllHotelByPriceAsc();

    
    List<Hotel> retrieveAllHotelByPriceDesc();

  
    List<Hotel> retrieveAllHotelBetweenPrices(float min,float max);

}	
