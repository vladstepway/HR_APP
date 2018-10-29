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
    public Interview getInterview(int id) {
        return jdbcTemplate.queryForObject("select * from interview where id = ?",
                new Object[]{id}, new InterviewRowMapper());
    }

    @Transactional
    public List<Interview> getAllInterviews() {
        return jdbcTemplate.query("select * from interview",
                new InterviewRowMapper());
    }

    @Transactional
    public List<String> getAllInterviewsID() {
        return jdbcTemplate.queryForList("select id from interview",
                String.class);
    }

    @Transactional
    public int addInterview(Interview interview) {
        String sql = "insert into interview (plan_date , fact_date , " +
                "vacancy_id, candidate_id) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                interview.getPlan_date(), interview.getFact_date(),
                interview.getVacancy_id(),
                interview.getCandidate_id());
    }

    @Transactional
    public int updateInterview(Interview interview) {
        return jdbcTemplate.update("update interview set plan_date = ?, fact_date = ?, " +
                        "vacancy_id = ?, candidate_id = ? where id = ?",
                interview.getPlan_date(), interview.getFact_date(),
                interview.getCandidate_id(), interview.getVacancy_id(),
                interview.getId());
    }

    @Transactional
    public int deleteInterview(int id) {
        return jdbcTemplate.update("delete from interview where id = ?", id);
    }


}