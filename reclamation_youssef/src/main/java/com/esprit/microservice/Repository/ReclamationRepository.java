package com.esprit.microservice.Repository;


import com.esprit.microservice.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository  extends JpaRepository<Reclamation,Integer> {

    @Query("select p from Reclamation p where p.reclamationName LIKE %:name% ")
    List<Reclamation> retrieveAllReclamationByName(@Param("name") String name);


    @Query("SELECT p from Reclamation p order by p.reclamationName desc ")
    List<Reclamation> retrieveAllReclamationByNameReclamationlDesc();

    @Query("select p from Reclamation p order by p.reclamationName asc")
    List<Reclamation> retrieveAllReclamationByNameReclamationAsc();
    @Query("select p from Reclamation p order by p.reclamationName desc")
    List<Reclamation> retrieveAllReclamationByNameReclamationDesc();

    @Query("select p from Reclamation p where p.idReclamation = :idReclamation")
    Reclamation retrieveReclamationById(@Param("idReclamation") int idReclamation);
    ;
}
