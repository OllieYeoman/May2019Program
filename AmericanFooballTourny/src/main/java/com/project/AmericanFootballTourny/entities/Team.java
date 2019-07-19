package com.project.AmericanFootballTourny.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // one copy for each test case
@EntityScan // Declares the class as an entity
@Table(name = "JPA_EMPLOYEE") // names the table created as JPA_EMPLOYEE
@EntityListeners({TeamLifeCycleListener.class})
@NamedQueries({
	@NamedQuery(name="Team.findByIncome",
			query="select e from Team e where e.Income between :min and :max")
	
})


public class Team implements Serializable {

	@Value("-1")
	private int teamno;
	@Value("Panthers")
	private String name;
	@Value("blue")
	private String colour;
	@Value("1000")
	private double income;	
		
//	private Set<Project> assignments = new HashSet<>();
//	// manyToMany configuring the association for both entities 
//	//joinTable provides all the configuration for the third table
//	//name: name of the join table
//	//joinColumn: Foregin Key column name for current class
//	//inverseJoinColumns: Foregin Key Column for other class
//	
//	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinTable(name="JPA_ASSIGNMENT", joinColumns=@JoinColumn(name="FK_EMPNO"),
//			inverseJoinColumns = @JoinColumn(name = "FK_PROJECTID"))
//	public Set<Project> getAssignments() {
//		return assignments;
//	}
//	public void setAssignments(Set<Project> assignments) {
//		this.assignments = assignments;
//	}
//	// many to one: each emp to one dep
//	private Department currentDepartment;
//	
//	@ManyToOne
//	@JoinColumn(name="FK_DepartmentId")
//	public Department getCurrentDepartment() {
//		return currentDepartment;
//	}
//	public void setCurrentDepartment(Department currentDepartment) {
//		this.currentDepartment = currentDepartment;
//	}
	
	
	//-------------------------------------
	public Team() {
		System.out.println("Team Created");
	}
	
	@Id
	@Column(name = "team_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTeamno() {
		return teamno;
	}

	@Column(name="team_name", nullable=false, length=45)
	public String getName() {
		return name;
	}
	public String getColour() {
		return colour;
	}
	public double getIncome() {
		return income;
	}
	public void setTeamno(int teamno) {
		this.teamno = teamno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Team [teamno=" + teamno + ", name=" + name + ", colours"+colour +", income=" + income + "]";
	}
}
