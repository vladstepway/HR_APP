package com.company.dao;

import com.company.model.InterviewFeedback;

import java.util.List;

public interface InterviewFeedbackDao extends GenericDao<InterviewFeedback, Integer> {

    InterviewFeedback getByPK(Integer interviewId);

    List<InterviewFeedback> getAll();

    List<String> getAllFeedbackStates();

    int create(InterviewFeedback interviewFeedback);

    int update(InterviewFeedback interviewFeedback);

    int delete(Integer interviewId);
}
