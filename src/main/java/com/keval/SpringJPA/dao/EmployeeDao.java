package com.keval.SpringJPA.dao;

import java.util.List;

import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;


public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployee(int employeeId);
	public void addEmployee(Employee employee);
	public void deleteEmployee(int employeeId);
	public void updateEmployee(Employee employee);
	public void deleteSkills(List<Skill> skillList);
}