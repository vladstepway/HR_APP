package com.company.dao.impl;

import com.company.dao.InterviewFeedbackDao;
import com.company.model.InterviewFeedback;
import com.company.model.mapper.InterviewFeedbackRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewFeedbackDaoImpl implements InterviewFeedbackDao {

    private final static String SELECT_QUERY_FOR_FEEDBACK =
            "select * from interview_feedback where interview_id = ?";
    private final static String SELECT_QUERY_FOR_ALL_FEEDBACK =
            "select * from interview_feedback";
    private final static String SELECT_QUERY_FOR_FEEDBACK_STATE =
            "select name from feedback_state";
    private final static String UPDATE_QUERY_FOR_FEEDBACK =
            "update interview_feedback set interviewer_id = ?, " +
                    "feedback_state = ?, reason = ? where interview_id = ?";
    private final static String DELETE_QUERY_FOR_FEEDBACK =
            "delete from interview_feedback where interview_id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public InterviewFeedback getInterviewFeedback(int interview_id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY_FOR_FEEDBACK,
                new Object[]{interview_id}, new InterviewFeedbackRowMapper());
    }

    @Transactional
    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        return jdbcTemplate.query(SELECT_QUERY_FOR_ALL_FEEDBACK,
                new InterviewFeedbackRowMapper());
    }

    @Transactional
    public List<String> getAllFeedbackStates() {
        return jdbcTemplate.queryForList(SELECT_QUERY_FOR_FEEDBACK_STATE,
                String.class);
    }

//    @Transactional
//    public int addInterviewFeedback(InterviewFeedback interviewFeedback) {
//        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        simpleJdbcInsert.withTableName("interview_feedback");
//        Map<String, Object> parameters = new HashMap<>(3);
//        parameters.put("interview_id", interviewFeedback.getInterview_id());
//        parameters.put("interviewer_id", interviewFeedback.getInterviewer_id());
//        parameters.put("feedback_state", interviewFeedback.getFeedback_state());
//        parameters.put("reason", interviewFeedback.getReason());
//        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
//        return insertedId.intValue();
//    }

    @Transactional
    public int addInterviewFeedback(InterviewFeedback interviewFeedback) {
        String sql = "insert into interview_feedback (interviewer_id , feedback_state , reason, interview_id) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                interviewFeedback.getInterviewer_id(), interviewFeedback.getFeedback_state(),
                interviewFeedback.getReason(),
                interviewFeedback.getInterview_id());
    }

    @Transactional
    public int updateInterviewFeedback(InterviewFeedback interviewFeedback) {
        return jdbcTemplate.update(UPDATE_QUERY_FOR_FEEDBACK,
                interviewFeedback.getInterviewer_id(),
                interviewFeedback.getFeedback_state(),
                interviewFeedback.getReason(),
                interviewFeedback.getInterview_id());
    }

    @Transactional
    public int deleteInterviewFeedback(int interview_id) {
        return jdbcTemplate.update(DELETE_QUERY_FOR_FEEDBACK, interview_id);
    }

}