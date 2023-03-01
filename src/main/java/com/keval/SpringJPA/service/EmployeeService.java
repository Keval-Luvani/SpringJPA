package com.keval.SpringJPA.service;

import java.util.List;

import com.keval.SpringJPA.model.Employee;

public interface EmployeeService {
	Employee fetchData(int employeeId);
	void deleteEmployee(int employeeId);
	List<Employee> viewEmployee();
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
}
