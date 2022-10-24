package com.esprit.microservice.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.Entity.Sejour;

public interface SejourRepository extends JpaRepository <Sejour,Integer>{

	
	 void deleteByDateArriveGreaterThan(Date var);
	
	
}
