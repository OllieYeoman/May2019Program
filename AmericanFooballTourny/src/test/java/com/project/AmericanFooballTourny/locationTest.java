package com.project.AmericanFooballTourny;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.project.AmericanFooballTourny.apis.LocationService;
import com.project.AmericanFootballTourny.entities.Location;


@RunWith(SpringRunner.class)
@SpringBootTest
public class locationTest {

	@Autowired
	LocationService LocService;
	
	@Autowired
	Location loc;
	
	@Test
	public void addLocationUsingService() {
		loc.setLocno(0); //setting empno to 0, the default, will add a new employee, setting empno to a current number will update it.
		loc.setName("superdome");
		loc.setDate("12/09/2019");
		loc = LocService.registerOrUpdateLocation(loc);
		assertNotNull(loc);
	}
	
	@Test
	public void findByLocnoUsingService() {
		int locno = 12;
		assertNotNull(LocService.findBylocno(locno));
	}	
	@Test
	public void deleteByLocnoUsingService() {
		int locno = 11;
		LocService.deleteByLocno(locno);
		assertNull(LocService.findBylocno(locno));
	}
	
	@Test
	public void checkFetchByLocation() {
		List<Location> locs = LocService.fetchLocationByName("Superdome");
		for (Location location : locs) {
			System.out.println(location);
			}
		assertEquals(locs.size(),2);}	


}

