package com.keval.SpringJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.keval.SpringJPA.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
}	
