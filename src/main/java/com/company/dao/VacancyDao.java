package com.company.dao;

import com.company.model.Vacancy;

import java.util.List;

public interface VacancyDao extends GenericDao<Vacancy, Integer> {

    Vacancy getByPK(Integer id);

    List<Vacancy> getAll();

    List<String> getAllVacancyID();

    List<String> getAllVacancyPosition();

    int create(Vacancy vacancy);

    int update(Vacancy vacancy);

    int delete(Integer id);
}
