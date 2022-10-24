package com.esprit.microservice.Controller;

import java.util.List;

import javax.ws.rs.core.Response;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Service.ISejourService;
import com.fasterxml.jackson.databind.JsonMappingException;


import com.esprit.microservice.Entity.Sejour;



@RestController
public class HotelRestApi {
	private String title="hello I'm the Hotel Microservice";
	

	@Autowired
	ISejourService sejourService; 
	
	
	
	
	@GetMapping("getsejours")
	@ResponseBody
	public List<Sejour> getFournisseurs() {
	List<Sejour> listF = sejourService.retrieveAllSjours();
	return listF;
	}
	
	

	@PostMapping("/addsejour")
	@ResponseBody
	public ResponseEntity<Response>  addsejour(@RequestPart("file") MultipartFile file,@RequestParam("sejour") String s)throws JsonParseException, JsonMappingException, Exception {
		 return sejourService.add(file,s);
	}
	
	
	/*@DeleteMapping(value="/id")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteSejour(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(sejourService.deletSejour(id),HttpStatus.OK);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	/*@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Response>  addHotel(@RequestPart("file") MultipartFile file,@RequestParam("hotel") String s)throws JsonParseException, JsonMappingException, Exception {
		 return hotelService.add(file,s);
	}*/
	
	
	
	/*@PutMapping("/update-Hotel/{id}")
	@ResponseBody
	ResponseEntity<Hotel> updateHotel(@PathVariable("id") int id,@RequestBody Hotel s){
		return hotelService.updateHotel(id,s);
	}*/
	
	
	
	/*@RequestMapping("/hello")
	
	public String sayHello(){
		
		System.out.println(title);
		return title;
	}*/
	
	/*@DeleteMapping(value="/id", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteHotel(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(hotelService.deleteHotel(id),HttpStatus.OK);

	}*/
}
