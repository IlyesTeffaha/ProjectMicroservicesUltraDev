package com.esprit.microservices.repositories;


import com.esprit.microservices.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    @Query("select p from Place p where p.PlaceTitle LIKE %:name% ")
    List<Place> retrieveAllPlacesByName(@Param("name") String name);
    @Query("select p from Place p where p.State LIKE %:state% ")
    List<Place> retrieveAllPlacesBystate(@Param("state") String state);
    @Query("select p from Place p where p.City LIKE %:city% ")
    List<Place> retrieveAllPlacesBycity(@Param("city") String city);
    @Query("select p from Place p where p.Country LIKE %:country% ")
    List<Place> retrieveAllPlacesBycountry(@Param("country") String country);
    @Query("SELECT p from Place p order by p.PlaceTitle desc ")
    List<Place> retrieveAllPlacesByNamePlacelDesc();

    @Query("select p from Place p order by p.PlaceTitle asc")
    List<Place> retrieveAllPlacesByNamePlaceAsc();
    @Query("select p from Place p order by p.PlaceTitle desc")
    List<Place> retrieveAllPlacesByNamePlaceDesc();

    @Query("select p from Place p where p.idPlace = :idPlace")
    Place retrievePlaceById(@Param("idPlace") int idPlace);
 ;

}
