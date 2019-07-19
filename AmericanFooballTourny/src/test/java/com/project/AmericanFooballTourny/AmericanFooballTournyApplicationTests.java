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

import com.project.AmericanFooballTourny.apis.TeamServices;
import com.project.AmericanFootballTourny.entities.Team;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmericanFooballTournyApplicationTests {

	@Autowired
	TeamServices teamService;
	
	@Autowired
	Team team;
	
	@Test
	public void addTeamsUsngService() {
		team.setTeamno(1);
		team.setName("new Team");
		team.setColour("colour");
		team.setIncome(1000);
		team = teamService.registerOrUpdateTeam(team);
		assertNotNull(team);
	}

	@Test
	public void findByTeamnoUsingService() {
		int teamno = 1;
		assertNotNull(teamService.findByTeamno(teamno));
	}	
	@Test
	public void deleteByTeamnoUsingService() {
		int teamno = 5;
		teamService.deleteByTeam(teamno);
		assertNull(teamService.findByTeamno(teamno));
	}
	
	@Test
	public void checkFetchBy() {
		List<Team> teams = teamService.fetchTeamByIncomeRange(0, 9000);
		for (Team team : teams) {
			System.out.println(team);
			}
		assertEquals(teams.size(),7);}	
}
