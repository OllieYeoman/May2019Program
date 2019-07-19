package com.project.AmericanFooballTourny.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entitiese.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;

@Component
@Scope("singleton")
public class MatchServices {

	
	@Autowired
	private MatchRepository matchRepository;
			
	public MatchService() {
		System.out.println("Match Service Created");
	}
	
	
	public Match registerOrUpdateMatch(Match match) {
		match = matchRepository.save(match);
		System.out.println("Match Registered" + match);
		return match;
	}


	public Match findByMatchno(int matchno) {
		try {
			return matchRepository.findById(matchno).get();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Match> fetchProjectByCustomer(String matchno){
			return matchRepository.findByMatchno(matchno);
	}
		
	
	public void deleteBymatchno(int matchno) {
		matchRepository.deleteById(matchno);
	}

}

