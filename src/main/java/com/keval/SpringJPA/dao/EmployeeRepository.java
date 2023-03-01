package com.keval.SpringJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keval.SpringJPA.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
