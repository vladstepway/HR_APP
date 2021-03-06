package com.company.service;

import com.company.model.Vacancy;

import java.util.List;

public interface VacancyService {

    Vacancy getVacancy(int id);

    List<Vacancy> getAllVacancies();

    List<String> getVacanciesID();

    List<String> getVacanciesPosition();

    int addVacancy(Vacancy vacancy);

    int updateVacancy(Vacancy vacancy);

    int deleteVacancy(int id);
}
