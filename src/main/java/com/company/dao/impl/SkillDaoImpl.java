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
    public Skill getSkill(String name) {
        return jdbcTemplate.queryForObject("select * from skill where name = ?",
                new Object[]{name}, new SkillRowMapper());
    }

    @Transactional
    public List<Skill> getAllSkills() {
        return jdbcTemplate.query("select * from skill",
                new SkillRowMapper());
    }

    @Transactional
    public int addSkill(Skill skill) {
        String sql = "insert into skill (name) values (?)";
        return jdbcTemplate.update(sql, skill.getName());
    }

    @Transactional
    public int updateSkill(Skill skill) {
        String sql = "update skill set name = ? where name = ?";
        return jdbcTemplate.update(sql, skill.getName(), new Skill().getName());

    }

    @Transactional
    public int deleteSkill(String name) {
        return jdbcTemplate.update("delete from skill where name = ?", name);
    }
}
