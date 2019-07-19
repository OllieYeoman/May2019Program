package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //one copy for each test case
@Entity // declares class as entity
@Table(name="JPA_Employee") // declaring table name for the class
@EntityListeners({EmployeeLifeCycleListener.class})
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary", 
			query="select e from Employee e where e.salary between :min and :max")
	
})

public class Employee 
implements Serializable{  //manage serialisation of object

	@Value("-1")
	private int empno;
	
	@Value("Default Employee")
	private String name;
	
	@Value("100.0")
	private double salary;
	
	private Set<Project> assignments= new HashSet<>();
	//@manyToMany: config the association for both the entities
	//@joinTable: Provides all the config for the third table
	//name: name of the Join table
	//joinColumns: Foreign Key column name for current class
	//inverseJoinColumn: foreign key column or other class
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_ASSIGNMENTS", 
	joinColumns=@JoinColumn(name="FK_EMPNO"), 
	inverseJoinColumns=@JoinColumn(name="FK_PROJECTID"))
		
	//@many to one: each employee belongs to one department 
	private Department currentDepartment;
	
	public Set<Project> getAssignments() {
		return assignments;
	}
	public void setAssignments(Set<Project> assignments) {
		this.assignments = assignments;
	}
	@ManyToOne
	@JoinColumn(name="FK_DepartmentId")
	public department getCurrentDepartment
	
	@Id // sets property of PK
	@Column(name="employee_number") // declare name of column
	@GeneratedValue(strategy = GenerationType.AUTO)//pk as increments
	public int getEmpno() {
		return empno;
	}
	@Column(name="employee_name", nullable=false, length=45)
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
