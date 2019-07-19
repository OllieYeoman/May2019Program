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

import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entitiese.Project;
import com.project.AmericanFooballTourny.apis.MatchServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchTest {

	@Autowired
	MatchServices matService;
	
	@Autowired
	Match match;
	
	@Test
	public void addProjectUsingService() {
		match.setMatchno(0); //setting empno to 0, the default, will add a new employee, setting empno to a current number will update it.
		match.setDate("12/09/2019");
		match.setTeam1("Panthers");
		match.setTeam2("Saints");
		match = MatchServices.registerOrUpdateMatch(match);
		assertNotNull(match);
	}
	
	@Test
	public void findByMatchnoUsingService() {
		int matchno = 16;
		assertNotNull(MatchServices.findByMatchno(matchno));
	}	
	@Test
	public void deleteByMatchUsingService() {
		int prono = 14;
		MatchServices.deleteByMatchno(prono);
		assertNull(MatchServices.findByMatchno(matchno));
	}
	
	@Test
	public void checkFetchByDate() {
		List<Match> matchs = MatchService.fetchMatchByDate("12/09/2019");
		for (Match match : matchs) {
			System.out.println(matchs);
			}
		assertEquals(matchs.size(),2);}	
	

}

}
