package com.esprit.microservices.Service;

import com.esprit.microservices.entities.Place;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IPlaceService {
    ResponseEntity<Response> addPlace(Place P) throws JsonParseException, JsonMappingException, Exception;

    ResponseEntity<Response> updatePlace(int id, Place P) throws JsonParseException, JsonMappingException, Exception;
    void deletePlace(int id);
    public List<Place> retrieveAllplaces() ;
    List<Place> retrieveAllPlacesByName(String name);
    List<Place> retrieveAllPlacesBystate( String state);
    List<Place> retrieveAllPlacesBycity( String city);
    List<Place> retrieveAllPlacesBycountry( String country);
    List<Place> retrieveAllPlacesByNamePlaceDesc();

    List<Place> retrieveAllPlacesByNamePlaceAsc();
    Place retrievePlaceById(int idPlace);

}