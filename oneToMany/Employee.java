package com.hibernateonetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id @Column(name="Employee_ID")
	private int eid;
	@Column(name="Employee_Name")
	private String ename;
	
	@ManyToOne
	private Project proj;

	//getter and setter
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}
	
	
}
