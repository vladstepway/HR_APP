package com.company.dao.impl;

import com.company.dao.InterviewFeedbackDao;
import com.company.model.InterviewFeedback;
import com.company.model.mapper.InterviewFeedbackRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InterviewFeedbackDaoImpl implements InterviewFeedbackDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public InterviewFeedback getInterviewFeedback(int interview_id) {
        return jdbcTemplate.queryForObject("select * from" +
                        " interview_feedback where interview_id = ?",
                new Object[]{interview_id}, new InterviewFeedbackRowMapper());
    }

    @Transactional
    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        return jdbcTemplate.query("select * from interview_feedback",
                new InterviewFeedbackRowMapper());
    }

    @Transactional
    public List<String> getAllFeedbackStates() {
        return jdbcTemplate.queryForList("select name from feedback_state",
                String.class);
    }

    @Transactional
    public int addInterviewFeedback(InterviewFeedback interviewFeedback) {
        String sql = "insert into interview_feedback (interviewer_id , feedback_state , " +
                "reason, interview_id) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                interviewFeedback.getInterviewer_id(), interviewFeedback.getFeedback_state(),
                interviewFeedback.getReason(),
                interviewFeedback.getInterview_id());
    }

    @Transactional
    public int updateInterviewFeedback(InterviewFeedback interviewFeedback) {
        return jdbcTemplate.update("update interview_feedback set interviewer_id = ?, " +
                        "feedback_state = ?, reason = ? where interview_id = ?",
                interviewFeedback.getInterviewer_id(),
                interviewFeedback.getFeedback_state(),
                interviewFeedback.getReason(),
                interviewFeedback.getInterview_id());
    }

    @Transactional
    public int deleteInterviewFeedback(int interview_id) {
        return jdbcTemplate.update("delete from interview_feedback where interview_id = ?",
                interview_id);
    }

}