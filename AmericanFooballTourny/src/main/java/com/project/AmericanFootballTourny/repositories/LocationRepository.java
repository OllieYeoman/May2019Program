package com.project.AmericanFootballTourny.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.project.AmericanFootballTourny.entities.Location;

@Component
public interface LocationRepository extends CrudRepository<Location, Integer> {
		public List<Location> findByName(
				@Param("name") String name);

	}



