package com.keval.SpringJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
	public List<Skill> findByEmployee(Employee employee);
}	
