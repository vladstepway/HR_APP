package com.company.service.impl;

import com.company.dao.InterviewFeedbackDao;
import com.company.model.InterviewFeedback;
import com.company.service.InterviewFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {
    @Autowired
    private InterviewFeedbackDao interviewFeedbackDao;

    public InterviewFeedback getInterviewFeedback(int id) {
        return interviewFeedbackDao.getByPK(id);
    }

    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        return interviewFeedbackDao.getAll();
    }
    public List<String> getFeedbackStates(){return interviewFeedbackDao.getAllFeedbackStates();}


    @Override
    public int addInterviewFeedback(InterviewFeedback user) {
        return interviewFeedbackDao.create(user);
    }

    @Override
    public int updateInterviewFeedback(InterviewFeedback user) {
        return interviewFeedbackDao.update(user);
    }

    @Override
    public int deleteInterviewFeedback(int id) {
        return interviewFeedbackDao.delete(id);
    }

    public InterviewFeedbackDao getInterviewFeedbackDao() {
        return interviewFeedbackDao;
    }
}