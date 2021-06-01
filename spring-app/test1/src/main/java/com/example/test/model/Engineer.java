package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import ch.qos.logback.classic.db.names.ColumnName;

@Entity
@Table(name="ENGINEER" , schema = "REST1")
public class Engineer {
	
	public Engineer() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	long id;
	
	@Column(name= "name")
	String name;
	
	@Column(name="dept")
	String dept;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
public  Engineer(Long id, String name, String dept) {
		
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

}
