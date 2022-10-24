package com.esprit.microservice.Controller;

import java.util.List;

import javax.ws.rs.core.Response;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.esprit.microservice.Service.IHotelService;
import com.fasterxml.jackson.databind.JsonMappingException;


import com.esprit.microservice.Entity.Hotel;



@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = {"http://localhost:3000"})
public class HotelController {
	private String title="hello I'm the Hotel Microservice";
	

	@Autowired
	IHotelService hotelService; 
	
	
	
	
	@GetMapping("/gethotels")
	@ResponseBody
	public List<Hotel> getHotels() {
	List<Hotel> listH = hotelService.retrieveAllhotels();
	return listH;
	}
	
	

	@PostMapping("/addhotel")
	@ResponseBody
	public ResponseEntity<Response>  addhotel(@RequestBody Hotel h)throws JsonParseException, JsonMappingException, Exception {
		 return hotelService.addHotel(h);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteHotel(@PathVariable(value="id") int  id){
		hotelService.deleteHotel(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	/*@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Response>  addHotel(@RequestPart("file") MultipartFile file,@RequestParam("hotel") String s)throws JsonParseException, JsonMappingException, Exception {
		 return hotelService.add(file,s);
	}*/
	
	
	
	@PutMapping("/update-Hotel/{id}")
	@ResponseBody
	public void updateHotel(@PathVariable("id") int id,@RequestBody Hotel s) throws Exception, JsonMappingException, Exception{
		 hotelService.updateHotel(id, s);
		 
	}
	
	
	
	@RequestMapping("/hello")
	
	public String sayHello(){
		
		System.out.println(title);
		return title;
	}
	
	/*@DeleteMapping(value="/id", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteHotel(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(hotelService.deleteHotel(id),HttpStatus.OK);

	}*/
}
