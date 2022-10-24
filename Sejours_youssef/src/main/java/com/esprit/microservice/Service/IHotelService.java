package com.esprit.microservice.Service;

import javax.ws.rs.core.Response;

//import javax.xml.ws.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Hotel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;





public interface IHotelService {

	ResponseEntity<Response> add(MultipartFile file, String Hotel)
			throws JsonParseException, JsonMappingException, Exception;
	
	ResponseEntity<Hotel> updateHotel(int id, Hotel s);
	// ResponseEntity<String> deleteHotel(int id);
	String deleteHotel(int id);
	
}
