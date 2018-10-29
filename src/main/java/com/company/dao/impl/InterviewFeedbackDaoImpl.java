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
    public InterviewFeedback getByPK(Integer interviewId) {
        return jdbcTemplate.queryForObject("select * from" +
                        " interview_feedback where interview_id = ?",
                new Object[]{interviewId}, new InterviewFeedbackRowMapper());
    }

    @Transactional
    public List<InterviewFeedback> getAll() {
        return jdbcTemplate.query("select * from interview_feedback",
                new InterviewFeedbackRowMapper());
    }

    @Transactional
    public List<String> getAllFeedbackStates() {
        return jdbcTemplate.queryForList("select name from feedback_state",
                String.class);
    }

    @Transactional
    public int create(InterviewFeedback interviewFeedback) {
        return jdbcTemplate.update("insert into interview_feedback (interviewer_id , " +
                        "feedback_state , reason, interview_id) values (?, ?, ?, ?)",
                interviewFeedback.getInterviewerId(), interviewFeedback.getFeedbackState(),
                interviewFeedback.getReason(),
                interviewFeedback.getInterviewId());
    }

    @Transactional
    public int update(InterviewFeedback interviewFeedback) {
        return jdbcTemplate.update("update interview_feedback set interviewer_id = ?, " +
                        "feedback_state = ?, reason = ? where interview_id = ?",
                interviewFeedback.getInterviewerId(),
                interviewFeedback.getFeedbackState(),
                interviewFeedback.getReason(),
                interviewFeedback.getInterviewId());
    }

    @Transactional
    public int delete(Integer interviewId) {
        return jdbcTemplate.update("delete from interview_feedback where interview_id = ?",
                interviewId);
    }

}