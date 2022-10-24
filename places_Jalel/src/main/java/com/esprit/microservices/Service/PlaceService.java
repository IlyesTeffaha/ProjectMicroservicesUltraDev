package com.esprit.microservices.Service;

import com.esprit.microservices.entities.Place;
import com.esprit.microservices.repositories.PlaceRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class PlaceService implements IPlaceService{
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    ServletContext context;

    @Override
    public ResponseEntity<Response> addPlace(Place P) throws JsonParseException, JsonMappingException, Exception {
        // TODO Auto-generated method stub
        Place place = placeRepository.save(P);



        if (place != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public ResponseEntity<Response> updatePlace(int id, Place p) throws JsonParseException, JsonMappingException, Exception {
        Place place = placeRepository.findById(id).get();
        if (place != null)
        {
            placeRepository.save(p);
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            placeRepository.save(place);
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }

    }
    @Override
    public void  deletePlace(int id) {
        // TODO Auto-generated method stub
        placeRepository.deleteById(id);
    }


    @Override
    public List<Place> retrieveAllplaces() {
        // TODO Auto-generated method stub
        return placeRepository.findAll();
    }
    @Override
    public List<Place> retrieveAllPlacesByName(String name) {
        // TODO Auto-generated method stub
        return placeRepository.retrieveAllPlacesByName(name);
    }
    @Override
    public List<Place> retrieveAllPlacesBystate(String state) {
        // TODO Auto-generated method stub
        return placeRepository.retrieveAllPlacesBystate(state);
    }
    @Override
    public List<Place> retrieveAllPlacesBycity(String city) {
        // TODO Auto-generated method stub
        return placeRepository.retrieveAllPlacesBystate(city);
    }
    @Override
    public List<Place> retrieveAllPlacesBycountry(String country) {
        // TODO Auto-generated method stub
        return placeRepository.retrieveAllPlacesBycountry(country);
    }
    @Override
    public List<Place> retrieveAllPlacesByNamePlaceDesc() {
        // TODO Auto-generated method stub
        return placeRepository.retrieveAllPlacesByNamePlaceDesc();
    }
    @Override
    public List<Place> retrieveAllPlacesByNamePlaceAsc() {
        // TODO Auto-generated method stub
        return placeRepository.retrieveAllPlacesByNamePlaceAsc();
    }
    @Override
    public Place retrievePlaceById(int idPlace) {
        // TODO Auto-generated method stub
        return placeRepository.retrievePlaceById(idPlace);
    }
}
