package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;

//Initialize the junit test with spring boot application env
//spring boot test: used to test spring application
//with all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrappApplicationTests {

	
	//scan in memory all the components and provide 
	//the best match object in the component
	@Autowired
	EmployeeService empService;
	//object creation should be handled by string 
	@Autowired
	Employee emp;
	
	@Test
	public void addEmployeeUsingService() {
	//	Employee emp = new Employee();
		emp.setEmpno(10);
		emp.setName("Example 10");
		emp.setSalary(4573);
		emp = empService.registerOrUpdateEmployee(emp);
		assertNotNull(emp);

	}
	
	@Test
	public void findByEmpnoUsingService() {
		int empno=1;
		assertNotNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void deleteByEmpnoUsingService() {
		int empno=2;
		empService.deleteByEmpno(empno);
		assertNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps=empService.fetchEmployeesBySalaryRange(0, 9000);
		for(Employee employee:emps) {
			System.out.println(employee);
		}
	assertEquals(emps.size(),7);
	
	}
	
	@Test
	public void contextLoads() {
		System.out.println("System Test Executed");
	}
	
	@Test
    public void manageAssociations() {
        Department d1 = new Department();
        d1.setDepName("Admin");
        d1.setLocation("Uk");
       
        Employee emp1 = new Employee();
        emp1.setName("Admin emp 1");
        emp1.setSalary(12123);
       
        Employee emp2 = new Employee();
        emp2.setName("Admin emp 2");
        emp2.setSalary(2344);
       
        Project p1 = new Project();
        p1.setProName("Uk project");
        p1.setCustomer("Uk customer");
       
        Project p2 = new Project();
        p2.setProName("Uk project 2");
        p2.setCustomer("cusotmer 2");
    }
	
	//one to many: one department
	d1.getMembers().add(emp1);
	d2.getMembers().add(emp2);

	emp1.getAssignments().add(p2);
	emp1.getAssignments().add(p1);
	emp2.getAssignments().add(p1);


}
