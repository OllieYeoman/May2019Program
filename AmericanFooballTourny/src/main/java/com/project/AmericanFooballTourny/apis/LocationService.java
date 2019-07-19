package com.project.AmericanFooballTourny.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.project.AmericanFootballTourny.entities.Location;
import com.project.AmericanFootballTourny.repositories.LocationRepository;

@Component
@Scope("singleton")
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
			
	public LocationService() {
		System.out.println("Location Service Created");
	}
	
	public Location registerOrUpdateLocation(Location loc) {
		loc = locationRepository.save(loc);
		System.out.println("Location Registered" +loc);
		return loc;
	}
	public Location findBylocno(int locno) {
		try {
			return locationRepository.findById(locno).get();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Location> fetchLocationByName(String name){
			return locationRepository.findByName(name);
	}
		
	
	public void deleteByLocno(int locno) {
		locationRepository.deleteById(locno);
	}
}
