package com.esprit.microservice.Controller;


import com.esprit.microservice.Entity.Reclamation;
import com.esprit.microservice.Service.IReclamationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/reclamation")
@CrossOrigin(origins = {"http://localhost:8090"})
public class ReclamationController {

    @Autowired
    IReclamationService reclamService;
    @GetMapping("getReclamations")
    @ResponseBody
    public List<Reclamation> getReclamations() {
        List<Reclamation> listR = reclamService.retrieveAllreclamations();
        return listR;
    }
    @PostMapping("/addReclamation")
    @ResponseBody
    public ResponseEntity<Response> addReclamation(@RequestBody Reclamation p)throws JsonParseException, JsonMappingException, Exception {
        return reclamService.addReclamation(p);
    }
    //MicroService Supprimer Reclamation avec ID
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReclamation(@PathVariable(value="id") int  id){
        reclamService.deleteReclamation(id);
    }

    @PutMapping("/updateReclamation/{id}")
    @ResponseBody
    public void updateReclamation(@PathVariable("id") int id,@RequestBody Reclamation p) throws Exception, JsonMappingException, Exception{
        reclamService.updateReclamation(id, p);

    }
    @GetMapping("/getReclamByName/{name}")
    @ResponseBody
    public List<Reclamation> getReclamationByName(@PathVariable("name") String name) throws Exception, JsonMappingException, Exception{
        List<Reclamation> listP = reclamService.retrieveAllReclamationsByName(name);
        return listP;
    }

    @GetMapping("getReclamById/{idReclamation}")
    @ResponseBody
    public Reclamation getReclamationById(@PathVariable("idReclamation") int idReclamation ) throws Exception, JsonMappingException, Exception{
        return reclamService.retrieveReclamationById(idReclamation);

    }
    @GetMapping("getReclamation/asc")
    @ResponseBody
    public List<Reclamation> getReclamationsAsc() {
        List<Reclamation> listP = reclamService.retrieveAllReclamationsByNameReclamationAsc();
        return listP;
    }
    @GetMapping("getReclamations/desc")
    @ResponseBody
    public List<Reclamation> getReclamationsDesc() {
        List<Reclamation> listP = reclamService.retrieveAllReclamationsByNameReclamationDesc();
        return listP;
    }


}
