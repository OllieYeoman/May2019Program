package com.project.AmericanFootballTourny.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@Component
public interface MatchRepository extends CrudRepository<Match, Integer> {
	public List<Match> findByDate(
				@Param("date") String date);

	}
	
