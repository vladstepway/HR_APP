package com.company.model.mapper;


import com.company.model.InterviewFeedback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class InterviewFeedbackRowMapper implements RowMapper<InterviewFeedback> {

    public InterviewFeedback mapRow(ResultSet rs, int row) throws SQLException {
        InterviewFeedback interviewFeedback = new InterviewFeedback();
        interviewFeedback.setInterviewId(rs.getInt("interview_id"));
        interviewFeedback.setInterviewerId(rs.getInt("interviewer_id"));
        interviewFeedback.setFeedbackState(rs.getString("feedback_state"));
        interviewFeedback.setReason(rs.getString("reason"));
        return interviewFeedback;
    }
}

