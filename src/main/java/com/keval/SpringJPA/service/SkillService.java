package com.keval.SpringJPA.service;

import java.util.List;

import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;

public interface SkillService {
	public List<Skill> updateSkill(Employee employee);
	public void deleteSkill();
}
