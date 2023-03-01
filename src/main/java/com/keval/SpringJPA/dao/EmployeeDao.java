package com.keval.SpringJPA.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.keval.SpringJPA.model.Employee;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	SkillRepository skillRepository;
	
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList = employeeRepository.findAll();
		for(Employee employee:employeeList) {
			employee.setSkillList(Arrays.asList(employee.getSkill().toString().replace("[","").replace("]","").replace(", ",",").split(",")));
		}
		return employeeList;
	}

	public Employee getEmployee(int employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee = optionalEmployee.get();
		employee.setSkillList(Arrays.asList(employee.getSkill().toString().replace("[","").replace("]","").replace(", ",",").split(",")));
		return employee;
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee); 
	}
	
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}