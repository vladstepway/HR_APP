package com.company.dao;

import com.company.model.InterviewFeedback;

import java.util.List;

public interface InterviewFeedbackDao {
    
    InterviewFeedback getInterviewFeedback(int interview_id);

    List<InterviewFeedback> getAllInterviewFeedbacks();

    List<String> getAllFeedbackStates();
    
    int addInterviewFeedback(InterviewFeedback interviewFeedback);

    int updateInterviewFeedback(InterviewFeedback interviewFeedback);

    int deleteInterviewFeedback(int interview_id);
}
