package com.esprit.microservice.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Sejour;
import com.esprit.microservice.Repository.SejourRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service

public class SejourService implements ISejourService {

	@Autowired
	private SejourRepository sejourRepository; 
	@Autowired
    ServletContext context;
	
	
	
	
	
	
	
	

	

	
	
	
	
	@Override
	public Sejour add(Sejour Sejour) throws JsonParseException, JsonMappingException, Exception {

		return sejourRepository.save(Sejour);

	}
	
	
    
	
	
	@Override
	public ResponseEntity<Sejour> updateSejour(int idSejour, Sejour newSejour) {
		
		
		if (sejourRepository.findById(idSejour).isPresent()) {
			Sejour existingSejour = sejourRepository.findById(idSejour).get();
			existingSejour.setTitre(newSejour.getTitre());
			existingSejour.setImage(newSejour.getImage());
			existingSejour.setPrix(newSejour.getPrix());	
			existingSejour.setDateArrive(existingSejour.getDateArrive());	
			existingSejour.setDatedepart(existingSejour.getDateArrive());
			
			existingSejour.setAvailability(existingSejour.isAvailability());		
			existingSejour.setDescription(existingSejour.getDescription());
			existingSejour.setCurrentCap(existingSejour.getCurrentCap());		
			existingSejour.setMaxCap(existingSejour.getMaxCap());
			existingSejour.setClientId(existingSejour.getClientId());

			


			 return new ResponseEntity<>(sejourRepository.save(existingSejour), HttpStatus.OK);
			} else
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	
	
	
	
	
	
	

	@Override
	public String deletSejour(int id) {
		if (sejourRepository.findById(id).isPresent()) {
			sejourRepository.deleteById(id);
			return "sejour supprimé";
} else
return "sejour non supprimé";
	}


	
	@Override
	public List<Sejour> retrieveAllSjours() {
		
		
		miseajour();
		
		
		List<Sejour> four =(List<Sejour> )sejourRepository.findAll();

		
		return four;
	}



















	@Override
	public ResponseEntity<Response> addsejour(Sejour Sejour)
			throws JsonParseException, JsonMappingException, Exception {
		
		


        Sejour art = sejourRepository.save(Sejour);



        if (art != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }

		
		
		
		
	}





	@Override
	public void miseajour() {
		
		
		
		List<Sejour> listedessejours =(List<Sejour> )sejourRepository.findAll();
		
		Date nowDate = new Date();

		for (Sejour sejour : listedessejours) {
			
			if(sejour.getDateArrive()!=null) {
		if(sejour.getDateArrive().compareTo(nowDate) < 0 ) {
			
			deletSejour(sejour.getIdSejour());
		}
		
			}
		}
		
	}





	@Override
	public void miseajour2() {
		
		Date nowDate = new Date();

			sejourRepository.deleteByDateArriveGreaterThan(nowDate);
		
	}













	/*@Override
	public ResponseEntity<Response> add(MultipartFile file, String Sejour)
			throws JsonParseException, JsonMappingException, Exception {
		// TODO Auto-generated method stub
		return null;
	}*/

}
