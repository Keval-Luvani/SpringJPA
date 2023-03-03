package com.keval.SpringJPA.dao;

import java.util.List;

import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;

public interface SkillDao {
	public void deleteSkills(List<Skill> skillList);
	public List<Skill> getSkills(Employee employee);
}
