package com.project.AmericanFooballTourny.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.project.AmericanFootballTourny.entities.Team;
import com.project.AmericanFootballTourny.repositories.TeamRepository;




@Component
@Scope("singleton")
public class TeamServices {
	
	@Autowired
	private TeamRepository teamRepository;
			
	public TeamServices() {
		System.out.println("Team Service Created");
	}
	
	
	public Team registerOrUpdateTeam(Team team) {
		team = teamRepository.save(team);
		System.out.println("Team Registered" + team);
		return team;
	}


	public Team findByTeamno(int teamno) {
		try {
			return teamRepository.findById(teamno).get();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Team> fetchTeamByIncomeRange(
		double min, double max){
			return teamRepository.findByIncome(min, max);
	}
		
	
	public void deleteByTeam(int teamno) {
		teamRepository.deleteById(teamno);
	}

}
