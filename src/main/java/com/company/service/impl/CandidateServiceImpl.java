package com.company.service.impl;

import com.company.dao.CandidateDao;
import com.company.model.Candidate;
import com.company.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDao candidateDao;

    public Candidate getCandidate(int id) {
        return candidateDao.getByPK(id);
    }

    public List<Candidate> getAllCandidates() {
        return candidateDao.getAll();
    }

    public List<String> getAllCandidatesID() {
        return candidateDao.getAllCandidatesID();
    }

    public List<String> getListOfStates() {
        return candidateDao.getListOfStates();
    }

    @Override
    public int addCandidate(Candidate candidate) {
        return candidateDao.create(candidate);
    }

    @Override
    public int updateCandidate(Candidate candidate) {
        return candidateDao.update(candidate);
    }

    @Override
    public int deleteCandidate(int id) {
        return candidateDao.delete(id);
    }

}
