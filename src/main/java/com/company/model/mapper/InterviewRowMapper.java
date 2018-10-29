package com.company.model.mapper;

import com.company.model.Interview;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterviewRowMapper implements RowMapper<Interview> {

    public Interview mapRow(ResultSet rs, int row) throws SQLException {
        Interview interview = new Interview();
        interview.setId(rs.getInt("id"));
        interview.setPlanDate(rs.getString("plan_date"));
        interview.setFactDate(rs.getString("fact_date"));
        interview.setVacancyId(rs.getInt("vacancy_id"));
        interview.setCandidateId(rs.getInt("candidate_id"));
        return interview;
    }
}

