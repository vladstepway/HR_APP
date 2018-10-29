package com.company.dao;

import com.company.model.Candidate;

import java.util.List;

public interface CandidateDao extends GenericDao<Candidate, Integer> {

    int create(Candidate candidate);

    Candidate getByPK(Integer key);

    int update(Candidate object);

    int delete(Integer id);

    List<Candidate> getAll();

    List<String> getAllCandidatesID();

    List<String> getListOfStates();


}
