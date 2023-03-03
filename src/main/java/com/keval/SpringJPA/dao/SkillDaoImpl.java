package com.keval.SpringJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;

@Component
public class SkillDaoImpl implements SkillDao {
	@Autowired
	SkillRepository skillRepository;
	
	public List<Skill> getSkills(Employee employee) {
		return skillRepository.findByEmployee(employee);
	}
	
	public void deleteSkills(List<Skill> deleteskillList) {
			skillRepository.deleteAll(deleteskillList);
			skillRepository.flush();
	}
}
