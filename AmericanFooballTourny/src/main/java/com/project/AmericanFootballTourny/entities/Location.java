package com.project.AmericanFootballTourny.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // one copy for each test case
@Entity // Declares the class as an entity
@Table(name = "JPA_Department") // names the table created as JPA_EMPLOYEE
//@EntityListeners({DepartmentLifeCycleListener.class})
@NamedQueries({
	@NamedQuery(name="Department.findByLocation",
			query="select e from Department e where e.location = : location")
	
})

public class Location implements Serializable {
	private int locno;
	private String name;
	private String date;
	private Set<Team> members = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "currentLocation")
	public Set<Team> getMembers() {
		return members;
	}
	
	public void setMembers(Set<Team> members) {
		this.members = members;
	}
	
	public Location() {
		System.out.println("Location Created");
	}
	
	@Id // Declare the property as Primary Key
	@Column(name = "department_number") // Declare the name of the column
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto generates the Primary key as incremented
	public int getLocno() {
		return locno;
	}

	@Column(name="department_name", nullable=false, length=45) // Column employee_name cannot be null or have a larger length than 45
	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public void setLocno(int locno) {
		this.locno = locno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Location [locno=" + locno + ", name=" + name + ", Date=" +date + "]";
	}

	
}
