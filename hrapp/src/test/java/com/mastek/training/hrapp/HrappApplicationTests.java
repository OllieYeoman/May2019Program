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

}
