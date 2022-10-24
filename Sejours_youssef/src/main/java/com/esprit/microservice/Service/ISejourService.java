package com.esprit.microservice.Service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Sejour;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ISejourService {
	
	ResponseEntity<Response> addsejour(Sejour Sejour)
	throws JsonParseException, JsonMappingException, Exception;
	
	ResponseEntity<Sejour> updateSejour(int id, Sejour s);
	String deletSejour(int id);
	
	public List<Sejour> retrieveAllSjours() ;

	Sejour add(Sejour Sejour) throws JsonParseException, JsonMappingException, Exception;
	
	void miseajour() ;
	
	void miseajour2() ;



}
