package com.esprit.microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.microservice.Entity.Hotel;

import java.util.Date;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository <Hotel,Integer>{
	
		@Query("select f from Hotel f where f.hotelName LIKE %:name% ")
	    List<Hotel> retrieveAllHotelByName(@Param("name") String name);
		
		@Query("select f from Hotel f where f.state LIKE %:state% ")
	    List<Hotel> retrieveAllHotelBystate(@Param("state") String state);

	   		@Query("select f from Hotel f where f.country LIKE %:country% ")
	    List<Hotel> retrieveAllHotelBycountry(@Param("country") String country);

	  

	    @Query("SELECT f from Hotel f order by f.hotelName desc ")
	    List<Hotel> retrieveAllHotelByNameHotelDesc();

	    @Query("select f from Hotel f order by f.hotelName asc")
	    List<Hotel> retrieveAllHotelByNameHotelAsc();

	    @Query("select f from Hotel f where f.idHotel = :idHotel")
	    Hotel retrieveHotelById(@Param("idHotel") Long idHotel);
	    
	    @Query("select f from Hotel f order by f.prixParJour asc ")
	    List<Hotel> retrieveAllHotelByPriceAsc();

	    @Query("select f from Hotel f order by f.prixParJour desc ")
	    List<Hotel> retrieveAllHotelByPriceDesc();

	    

	    
	    @Query("select f from Hotel f where f.prixParJour between :max and :min")
	    List<Hotel> retrieveAllHotelBetweenPrices(@Param("min") float min, @Param("max") float max);


	    

}
