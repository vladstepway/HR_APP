package com.company.dao.impl;

import com.company.dao.SkillDao;
import com.company.model.Skill;
import com.company.model.mapper.SkillRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SkillDaoImpl implements SkillDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Skill getByPK(String name) {
        return jdbcTemplate.queryForObject("select * from skill where name = ?",
                new Object[]{name}, new SkillRowMapper());
    }

    @Transactional
    public List<Skill> getAll() {
        return jdbcTemplate.query("select * from skill",
                new SkillRowMapper());
    }

    @Transactional
    public int create(Skill skill) {
        return jdbcTemplate.update("insert into skill (name) value (?)",
                skill.getName());
    }

    @Transactional
    public int update(Skill skill) {
        return jdbcTemplate.update("update skill set name = ? where name = ?",
                skill.getName(), skill.getName());

    }

    @Transactional
    public int delete(String name) {
        return jdbcTemplate.update("delete from skill where name = ?", name);
    }
}
