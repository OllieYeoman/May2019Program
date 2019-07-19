package com.project.AmericanFootballTourny.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // one copy for each test case
@Entity // Declares the class as an entity
@Table(name = "JPA_Project") // names the table created as JPA_EMPLOYEE
//@EntityListeners({DepartmentLifeCycleListener.class})
@NamedQueries({
	@NamedQuery(name="Project.findByCustomer",
			query="select e from Project e where e.customer = : customer")
	
})

public class Match {
	@Value("-1")
	private int matchno;
	@Value("12/09/2019")
	private String date;
	@Value("Panthers")
	private String team1;
	@Value("Saints")
	private String team2;
	
//	private Set<Team>  = new HashSet<>();
//	
//	// mappedBy: check the configurations for Many to Many associations 
//	// In employee class getAssignments() method
//	@ManyToMany(mappedBy = "assignments")
//	public Set<Employee> getTeam() {
//		return team;
//	}
//
//
//	public void setTeam(Set<Employee> team) {
//		this.team = team;
//	}
	
	public Match() {
		System.out.println("Match created");
	}
	
	@Id // Declare the property as Primary Key
	@Column(name = "project_number") // Declare the name of the column
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto generates the Primary key as incremented
	public int getMatchno() {
		return matchno;
	}
	
	@Column(name="project_name", nullable=false, length=45) // Column employee_name cannot be null or have a larger length than 45
	public String getDate() {
		return date;
	}
	public String getTeam1() {
		return team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setMatchno(int matchno) {
		this.matchno = matchno;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	
	@Override
	public String toString() {
		return "Match [matchno=" + matchno + ", date=" + date + ", team1" + team1  + ", team2"+ team2 +"]";
	}

}
