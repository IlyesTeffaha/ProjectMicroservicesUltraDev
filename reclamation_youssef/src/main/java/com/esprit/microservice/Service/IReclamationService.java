package com.esprit.microservice.Service;

import com.esprit.microservice.Entity.Reclamation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IReclamationService {
    ResponseEntity<Response> addReclamation(Reclamation R) throws JsonParseException, JsonMappingException, Exception;

    ResponseEntity<Response> updateReclamation(int id, Reclamation r) throws JsonParseException, JsonMappingException, Exception;

    void deleteReclamation(int id);

    List<Reclamation> retrieveAllreclamations();

    List<Reclamation> retrieveAllReclamationsByName(String name);

    List<Reclamation> retrieveAllReclamationsByNameReclamationDesc();

    List<Reclamation> retrieveAllReclamationsByNameReclamationAsc();

    Reclamation retrieveReclamationById(int idReclamation);
}
