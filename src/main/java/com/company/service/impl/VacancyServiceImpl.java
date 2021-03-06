package com.company.service.impl;

import com.company.dao.VacancyDao;
import com.company.model.Vacancy;
import com.company.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VacancyServiceImpl implements VacancyService {
    @Autowired
    private VacancyDao vacancyDao;

    @Override
    public Vacancy getVacancy(int id) {
        return vacancyDao.getByPK(id);
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        return vacancyDao.getAll();
    }

    public List<String> getVacanciesID() {
        return vacancyDao.getAllVacancyID();
    }

    public List<String> getVacanciesPosition() {
        return vacancyDao.getAllVacancyPosition();
    }


    @Override
    public int addVacancy(Vacancy vacancy) {
        return vacancyDao.create(vacancy);
    }

    @Override
    public int updateVacancy(Vacancy vacancy) {
        return vacancyDao.update(vacancy);
    }

    @Override
    public int deleteVacancy(int id) {
        return vacancyDao.delete(id);
    }
}
