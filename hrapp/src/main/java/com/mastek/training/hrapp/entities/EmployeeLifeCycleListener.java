package com.mastek.training.hrapp.entities;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EmployeeLifeCycleListener {

	
	// life-cycle methods, 
	//@<Event>
	//public void <name(Entity e)
	
	@PrePersist
	public void beforeInsert(Employee e) {
		System.out.println("Before Insert: "+e);
	}
	
	@PostPersist
	public void afterInsert(Employee e) {
		System.out.println("After Insert: "+e);
	}
	
	@PreUpdate
	public void beforeUpdate(Employee e) {
		System.out.println("before Update: "+e);
	}
	
	@PostUpdate
	public void afterUpdate(Employee e) {
		System.out.println("after Update: "+e);
	}
	
	@PreRemove
	public void beforeDelete(Employee e) {
		System.out.println("before delete: "+e);
	}
	
	@PostRemove
	public void afterSelect(Employee e) {
		System.out.println("after select: "+e);
	}
}
	

