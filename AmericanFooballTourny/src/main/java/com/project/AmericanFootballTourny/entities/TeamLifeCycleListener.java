package com.project.AmericanFootballTourny.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TeamLifeCycleListener {		
		//life cycle methods should be:
		//public, void and <name>(entity e)
		
		@PrePersist
		public void beforeInsert(Team e) {
			System.out.println("Before Insert: "+e);
		}
		@PostPersist
		public void afterInsert(Team e) {
			System.out.println("After Insert: "+e);
		}
		
		@PreUpdate
		public void beforeUpdate(Team e) {
			System.out.println("Before Update: "+e);
		}
		@PostUpdate
		public void afterUpdate(Team e) {
			System.out.println("After Update: "+e);
		}	
		
		@PreRemove
		public void beforeDelete(Team e) {
			System.out.println("Before Delete: "+e);
		}
		@PostLoad
		public void afterSelect(Team e) {
			System.out.println("After Select: "+e);
		}
	}

