package com.company.dao;

import com.company.model.Interview;

import java.util.List;

public interface InterviewDao extends GenericDao<Interview, Integer> {

    int create(Interview interview);

    Interview getByPK(Integer key);

    int update(Interview object);

    int delete(Integer id);

    List<Interview> getAll();

    List<String> getAllInterviewsID();

}
