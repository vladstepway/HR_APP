package com.company.dao.impl;

import com.company.dao.CandidateDao;
import com.company.model.Candidate;
import com.company.model.mapper.CandidateRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateDaoImpl implements CandidateDao {
    private static final String SELECT_QUERY_FOR_CANDIDATE =
            "select * from candidate where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Candidate getCandidate(int id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY_FOR_CANDIDATE,
                new Object[]{id}, new CandidateRowMapper());
    }

    @Transactional
    public List<Candidate> getAllCandidates() {
        List<Candidate> candidateList = jdbcTemplate.query("select * from candidate",
                new CandidateRowMapper());
        return candidateList;
    }

    @Transactional
    public List<String> getAllCandidatesID() {
        return jdbcTemplate.queryForList("select id from candidate", String.class);
    }

    @Transactional
    public List<String> getListOfStates() {
        return jdbcTemplate.queryForList("select name from candidate_state", String.class);
    }


    @Transactional
    public int addCandidate(Candidate candidate) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("candidate").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(5);
        parameters.put("name", candidate.getName());
        parameters.put("surname", candidate.getSurname());
        parameters.put("birthday", candidate.getBirthday());
        parameters.put("expected_salary", candidate.getExpected_salary());
        parameters.put("candidate_state", candidate.getCandidate_state());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateCandidate(Candidate candidate) {
        String sql = "update candidate set name = ?, surname = ?, birthday = ?, expected_salary = ?,candidate_state= ? where id = ?";
        int resp = jdbcTemplate.update(sql, candidate.getName(), candidate.getSurname(),
                candidate.getBirthday(), candidate.getExpected_salary(), candidate.getCandidate_state(), candidate.getId());
        return resp;

    }

    @Transactional
    public int deleteCandidate(int id) {
        int resp = jdbcTemplate.update("delete from candidate where id = ?", id);
        return resp;
    }
}
