package com.company.dao.impl;

import com.company.dao.CandidateDao;
import com.company.model.Candidate;
import com.company.model.mapper.CandidateRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CandidateDaoImpl implements CandidateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Candidate getByPK(Integer id) {
        return jdbcTemplate.queryForObject("select * from candidate where id = ?",
                new Object[]{id}, new CandidateRowMapper());
    }

    @Transactional
    public List<Candidate> getAll() {
        return jdbcTemplate.query("select * from candidate",
                new CandidateRowMapper());
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
    public int create(Candidate candidate) {
        return jdbcTemplate.update("insert into candidate (name,surname,birthday," +
                        "expected_salary,candidate_state)" +
                        " values (?, ?, ?, ?,?)",
                candidate.getName(),
                candidate.getSurname(),
                candidate.getBirthday(),
                candidate.getExpectedSalary(),
                candidate.getCandidateState());
    }

    @Transactional
    public int update(Candidate candidate) {
        return jdbcTemplate.update("update candidate set name = ?, surname = ?," +
                        " birthday = ?, expected_salary = ?,candidate_state= ? where id = ?",
                candidate.getName(), candidate.getSurname(),
                candidate.getBirthday(), candidate.getExpectedSalary(),
                candidate.getCandidateState(), candidate.getId());

    }

    @Transactional
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from candidate where id = ?", id);
    }
}
