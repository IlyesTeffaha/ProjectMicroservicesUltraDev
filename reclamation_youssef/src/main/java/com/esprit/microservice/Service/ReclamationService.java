package com.esprit.microservice.Service;

import com.esprit.microservice.Entity.Reclamation;
import com.esprit.microservice.Repository.ReclamationRepository;
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
public class ReclamationService implements IReclamationService {

    @Autowired

    private ReclamationRepository reclamRepo;
    @Autowired
    ServletContext context;

    @Override
    public ResponseEntity<Response> addReclamation(Reclamation R) throws JsonParseException, JsonMappingException, Exception {
        // TODO Auto-generated method stub
        Reclamation reclamation = reclamRepo.save(R);



        if (reclamation != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Response> updateReclamation(int id, Reclamation r) throws JsonParseException, JsonMappingException, Exception {
        Reclamation reclamation = reclamRepo.findById(id).get();
        if (reclamation != null)
        {
            reclamRepo.save(r);
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            reclamRepo.save(reclamation);
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }

    }
    @Override
    public void  deleteReclamation(int id) {
        // TODO Auto-generated method stub
        reclamRepo.deleteById(id);
    }


    @Override
    public List<Reclamation> retrieveAllreclamations() {
        // TODO Auto-generated method stub
        return reclamRepo.findAll();
    }
    @Override
    public List<Reclamation> retrieveAllReclamationsByName(String name) {
        // TODO Auto-generated method stub
        return reclamRepo.retrieveAllReclamationByName(name);
    }

    @Override
    public List<Reclamation> retrieveAllReclamationsByNameReclamationDesc() {
        // TODO Auto-generated method stub
        return reclamRepo.retrieveAllReclamationByNameReclamationDesc();
    }
    @Override
    public List<Reclamation> retrieveAllReclamationsByNameReclamationAsc() {
        // TODO Auto-generated method stub
        return reclamRepo.retrieveAllReclamationByNameReclamationAsc();
    }
    @Override
    public Reclamation retrieveReclamationById(int idReclamation) {
        // TODO Auto-generated method stub
        return reclamRepo.retrieveReclamationById(idReclamation);
    }
}
