package com.empresa.empresa.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String empName;
	
	@ManyToMany
	@JoinTable(name = "employee_project",
	joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="project_id")
			)
	private Set<Project>projects = new HashSet<>();
	
	public Employee() {
		
	}

	public Employee(Long empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
	
	
	
	
}
