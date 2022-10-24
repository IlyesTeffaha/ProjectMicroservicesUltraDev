package com.esprit.microservices.Controller;


import com.esprit.microservices.Service.IPlaceService;
import com.esprit.microservices.entities.Place;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = {"http://localhost:8090"})
public class PlaceController {
    @Autowired
    IPlaceService placeService;
    @GetMapping("getplaces")
    @ResponseBody
    public List<Place> getPlaces() {
        List<Place> listP = placeService.retrieveAllplaces();
        return listP;
    }
    @PostMapping("/addplace")
    @ResponseBody
    public ResponseEntity<Response> addplace(@RequestBody Place p)throws JsonParseException, JsonMappingException, Exception {
        return placeService.addPlace(p);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlace(@PathVariable(value="id") int  id){
        placeService.deletePlace(id);
    }
    @PutMapping("/update-Place/{id}")
    @ResponseBody
    public void updatePlace(@PathVariable("id") int id,@RequestBody Place p) throws Exception, JsonMappingException, Exception{
        placeService.updatePlace(id, p);

    }
    @GetMapping("getplace/{name}")
    @ResponseBody
    public List<Place> getPlaceByName(@PathVariable("name") String name) throws Exception, JsonMappingException, Exception{
        List<Place> listP = placeService.retrieveAllPlacesByName(name);
        return listP;
    }
    @GetMapping("getplace/state/{state}")
    @ResponseBody
    public List<Place> getPlaceByState(@PathVariable("state") String state) throws Exception, JsonMappingException, Exception{
        List<Place> listP = placeService.retrieveAllPlacesBystate(state);
        return listP;
    }
    @GetMapping("getplace/city/{city}")
    @ResponseBody
    public List<Place> getPlaceByCity(@PathVariable("city") String city) throws Exception, JsonMappingException, Exception{
        List<Place> listP = placeService.retrieveAllPlacesBycity(city);
        return listP;
    }
    @GetMapping("getplace/country/{country}")
    @ResponseBody
    public List<Place> getPlaceByCountry(@PathVariable("country") String country) throws Exception, JsonMappingException, Exception{
        List<Place> listP = placeService.retrieveAllPlacesBycountry(country);
        return listP;
    }

    @GetMapping("getplaceById/{idPlace}")
    @ResponseBody
    public Place getPlaceById(@PathVariable("idPlace") int idPlace) throws Exception, JsonMappingException, Exception{
        return placeService.retrievePlaceById(idPlace);

    }
    @GetMapping("getplaces/asc")
    @ResponseBody
    public List<Place> getPlacesAsc() {
        List<Place> listP = placeService.retrieveAllPlacesByNamePlaceAsc();
        return listP;
    }
    @GetMapping("getplaces/desc")
    @ResponseBody
    public List<Place> getPlacesDesc() {
        List<Place> listP = placeService.retrieveAllPlacesByNamePlaceDesc();
        return listP;
    }


}
