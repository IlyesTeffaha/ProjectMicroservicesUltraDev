package com.esprit.microservice.Service;

import java.io.File;
import java.util.Optional;

import javax.servlet.ServletContext;
//import javax.xml.ws.Response;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
///import org.omg.CORBA.IntHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Hotel;
import com.esprit.microservice.Repository.HotelRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;







@Service
public class HotelService implements IHotelService {

	
	@Autowired
	private HotelRepository hotelRepository; 
	@Autowired
    ServletContext context;
	
	@Override
    public ResponseEntity<Response> add(MultipartFile file, String Hotel) throws JsonParseException, JsonMappingException, Exception
    {

        System.out.println("Ok .............");
        Hotel s = new ObjectMapper().readValue(Hotel, Hotel.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir success.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        s.setImage(newFileName);

        Hotel art = hotelRepository.save(s);



        if (art != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }



    }

	public ResponseEntity<Hotel> updateHotel(int idHotel, Hotel newHotel) {
		if (hotelRepository.findById(idHotel).isPresent()) {
			Hotel existingHotel = hotelRepository.findById(idHotel).get();
			existingHotel.setNom(newHotel.getNom());
			existingHotel.setDescription(newHotel.getDescription());
			existingHotel.setImage(newHotel.getImage());
			existingHotel.setPrix(newHotel.getPrix());

			 return new ResponseEntity<>(hotelRepository.save(existingHotel), HttpStatus.OK);
			} else
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	

}
	
	
	public String deleteHotel(int id) {
		if (hotelRepository.findById(id).isPresent()) {
			hotelRepository.deleteById(id);
			return "hotel supprimé";
} else
return "hotel non supprimé";
	}
	
	
	
	
	
	
}
