package com.empresa.empresa.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.entities.Employee;
import com.empresa.empresa.entities.Project;
import com.empresa.empresa.repositories.EmployeeRepository;
import com.empresa.empresa.repositories.ProjectRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	/*POST */
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	/* GETAll e GetByID */
	public List<Employee> getEmployeeDetails(Long empId){
		if(null != null) {
			return employeeRepository.findAllByEmpId(empId);
		} else {
			return employeeRepository.findAll();
		}
	}
	
	/* DELETE */
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}
	
	/*PUT */
	public Employee assignProjectToEmployee(Long empId, Long projectId) {
		Set<Project> projectSet = null;
		Employee employee = employeeRepository.findById(empId).get();
		Project project = projectRepository.findById(projectId).get();
		projectSet = employee.getProjects();
		projectSet.add(project);
		employee.setProjects(projectSet);
		return employeeRepository.save(employee);
	}
}
