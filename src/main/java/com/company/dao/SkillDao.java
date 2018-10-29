package com.company.dao;

import com.company.model.Skill;

import java.util.List;

public interface SkillDao extends GenericDao<Skill, String> {

    Skill getByPK(String name);

    List<Skill> getAll();

    int create(Skill skill);

    int update(Skill skill);

    int delete(String name);
}
