package com.company.model;

import java.util.Objects;

public class Vacancy {
    private int id;
    private String position;
    private Double salaryFrom;
    private Double salaryTo;
    private String vacancyState;
    private Double experienceYearsRequire;
    private int creatorId;

    public Vacancy() {
    }

    public Vacancy(int id, String position,
                   Double salaryFrom,
                   Double salaryTo,
                   String vacancyState,
                   Double experienceYearsRequire,
                   int creatorId) {
        this.id = id;
        this.position = position;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.vacancyState = vacancyState;
        this.experienceYearsRequire = experienceYearsRequire;
        this.creatorId = creatorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(Double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public Double getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(Double salaryTo) {
        this.salaryTo = salaryTo;
    }

    public String getVacancyState() {
        return vacancyState;
    }

    public void setVacancyState(String vacancyState) {
        this.vacancyState = vacancyState;
    }

    public Double getExperienceYearsRequire() {
        return experienceYearsRequire;
    }

    public void setExperienceYearsRequire(Double experienceYearsRequire) {
        this.experienceYearsRequire = experienceYearsRequire;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return getId() == vacancy.getId() &&
                getCreatorId() == vacancy.getCreatorId() &&
                Objects.equals(getPosition(), vacancy.getPosition()) &&
                Objects.equals(getSalaryFrom(), vacancy.getSalaryFrom()) &&
                Objects.equals(getSalaryTo(), vacancy.getSalaryTo()) &&
                Objects.equals(getVacancyState(), vacancy.getVacancyState()) &&
                Objects.equals(getExperienceYearsRequire(), vacancy.getExperienceYearsRequire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getPosition(),
                getSalaryFrom(),
                getSalaryTo(),
                getVacancyState(),
                getExperienceYearsRequire(),
                getCreatorId());
    }


}
