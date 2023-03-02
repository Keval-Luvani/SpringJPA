package com.keval.SpringJPA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringJPA.dao.EmployeeDao;
import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDaoImpl;
	
	public Employee fetchData(int employeeId) {
		Employee employee = employeeDaoImpl.getEmployee(employeeId);
        return employee;
	}

	public void deleteEmployee(int employeeId) {
		employeeDaoImpl.deleteEmployee(employeeId);
		return ; 
	}

	public List<Employee> viewEmployee() {
		List<Employee> employeeList = employeeDaoImpl.getEmployees();
	    return employeeList;
	}

	public void createEmployee(Employee employee) {
		List<Skill> skillList = new ArrayList<>();
		employee.setSkill(null);	
		for(String skill: employee.getSkillList()) {
			Skill tempSkill = new Skill();
			tempSkill.setEmployee(employee);
			tempSkill.setSkill(skill);
			skillList.add(tempSkill);
		}
		employee.setSkill(skillList);
		employeeDaoImpl.addEmployee(employee);
		return;	
	}

	public void updateEmployee(Employee employee) {
		List<Skill> skillList = new ArrayList<>();
		for(String skill: employee.getSkillList()) {
			Skill tempSkill = new Skill();
			tempSkill.setEmployee(employee);
			tempSkill.setSkill(skill);
			skillList.add(tempSkill);
		}
		employee.setSkill(skillList);
		employeeDaoImpl.updateEmployee(employee);
		return;
	}
}	
