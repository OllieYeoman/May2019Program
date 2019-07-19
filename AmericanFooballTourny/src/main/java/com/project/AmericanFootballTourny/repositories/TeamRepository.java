package com.project.AmericanFootballTourny.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.project.AmericanFootballTourny.entities.Team;

@Component
public interface TeamRepository 
	extends CrudRepository<Team, Integer>{
	
	// declare the custom query method, with the same name as query
	public List<Team> findByIncome(
			@Param("min") Double min, // declare the parameter name 
			@Param("max") Double max); 
	
}