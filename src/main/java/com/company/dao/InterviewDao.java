package com.company.dao;

import com.company.model.Interview;

import java.util.List;

public interface InterviewDao {
     Interview getInterview(int id);

     List<Interview> getAllInterviews();
     List<String> getAllInterviewsID();


     int addInterview(Interview interview);

     int updateInterview(Interview interview);

     int deleteInterview(int id);
}
