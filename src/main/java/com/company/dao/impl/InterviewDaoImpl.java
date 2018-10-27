package com.company.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Interview;
import com.company.model.mapper.InterviewRowMapper;
import com.company.dao.InterviewDao;

public class InterviewDaoImpl implements InterviewDao {

    private final static String SELECT_QUERY_FOR_INTERVIEW =
            "select * from interview where id = ?";
    private final static String SELECT_QUERY_FOR_ALL_INTERVIEW =
            "select * from interview";
    private final static String SELECT_QUERY_FOR_ALL_INTERVIEW_ID =
            "select id from interview";
    private final static String UPDATE_QUERY_FOR_INTERVIEW =
            "update interview set plan_date = ?, fact_date = ?, " +
                    "vacancy_id = ?, candidate_id = ? where id = ?";
    private final static String DELETE_QUERY_FOR_INTERVIEW =
            "delete from interview where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Interview getInterview(int id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY_FOR_INTERVIEW,
                new Object[]{id}, new InterviewRowMapper());
    }

    @Transactional
    public List<Interview> getAllInterviews() {
        return jdbcTemplate.query(SELECT_QUERY_FOR_ALL_INTERVIEW,
                new InterviewRowMapper());
    }

    @Transactional
    public List<String> getAllInterviewsID() {
        return jdbcTemplate.queryForList(SELECT_QUERY_FOR_ALL_INTERVIEW_ID,
                String.class);
    }

    @Transactional
    public int addInterview(Interview interview) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("interview").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("plan_date", interview.getPlan_date());
        parameters.put("fact_date", interview.getFact_date());
        parameters.put("vacancy_id", interview.getVacancy_id());
        parameters.put("candidate_id", interview.getCandidate_id());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateInterview(Interview interview) {
        return jdbcTemplate.update(UPDATE_QUERY_FOR_INTERVIEW,
                interview.getPlan_date(), interview.getFact_date(),
                interview.getCandidate_id(), interview.getVacancy_id(),
                interview.getId());
    }

    @Transactional
    public int deleteInterview(int id) {
        return jdbcTemplate.update(DELETE_QUERY_FOR_INTERVIEW, id);
    }


}