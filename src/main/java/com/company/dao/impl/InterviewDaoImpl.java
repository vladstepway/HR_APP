package com.company.dao.impl;

import com.company.dao.InterviewDao;
import com.company.model.Interview;
import com.company.model.mapper.InterviewRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InterviewDaoImpl implements InterviewDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Interview getByPK(Integer id) {
        return jdbcTemplate.queryForObject("select * from interview where id = ?",
                new Object[]{id}, new InterviewRowMapper());
    }

    @Transactional
    public List<Interview> getAll() {
        return jdbcTemplate.query("select * from interview",
                new InterviewRowMapper());
    }

    @Transactional
    public List<String> getAllInterviewsID() {
        return jdbcTemplate.queryForList("select id from interview",
                String.class);
    }

    @Transactional
    public int create(Interview interview) {
        return jdbcTemplate.update("insert into interview (plan_date , fact_date , " +
                        "vacancy_id, candidate_id) values (?, ?, ?, ?)",
                interview.getPlanDate(), interview.getFactDate(),
                interview.getVacancyId(),
                interview.getCandidateId());
    }


    @Transactional
    public int update(Interview interview) {
        return jdbcTemplate.update("update interview set plan_date = ?, fact_date = ?, " +
                        "vacancy_id = ?, candidate_id = ? where id = ?",
                interview.getPlanDate(), interview.getFactDate(),
                interview.getCandidateId(), interview.getVacancyId(),
                interview.getId());
    }

    @Transactional
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from interview where id = ?", id);
    }


}