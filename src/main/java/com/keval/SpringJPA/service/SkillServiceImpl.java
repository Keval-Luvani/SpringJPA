package com.keval.SpringJPA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringJPA.dao.SkillDao;
import com.keval.SpringJPA.model.Employee;
import com.keval.SpringJPA.model.Skill;

@Component
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillDao skillDaoImpl;
	
	List<Skill> deleteSkillList = new ArrayList<>();
	
	public List<Skill> updateSkill(Employee employee) {
		List<Skill> addSkillList = new ArrayList<>();
		List<Skill> databaseSkillList = skillDaoImpl.getSkills(employee);
		
		for(String skill: employee.getSkillList()) {
			boolean add = true;
			for(Skill databaseSkill : databaseSkillList) {
				if(databaseSkill.getSkill().equals(skill)) {
					add = false;
					break;
				}
			}
			if(add) {
				Skill tempSkill = new Skill();
				tempSkill.setEmployee(employee);
				tempSkill.setSkill(skill);
				addSkillList.add(tempSkill);
			}
		}
		
		for(Skill databaseSkill : databaseSkillList) {
			if(!employee.getSkillList().contains(databaseSkill.getSkill())) {
				deleteSkillList.add(databaseSkill);
			}
		}
		
		System.out.println("addSkillList"+ addSkillList);
		System.out.println("deleteSkillList"+ deleteSkillList);
		
		return addSkillList;
	}
	
	public void deleteSkill() {
		skillDaoImpl.deleteSkills(deleteSkillList);
		deleteSkillList.clear();
	}
	
}
