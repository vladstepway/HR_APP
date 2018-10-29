package com.company.model;


import javax.validation.constraints.NotNull;

/**
 *
 */
public class Candidate {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Date
    private String birthday;
    private Double expectedSalary;
    private String candidateState;

    public Candidate() {}

    public Candidate(int id, String name, String surname, String birthday,
                     Double expectedSalary, String candidateState) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.expectedSalary = expectedSalary;
        this.candidateState = candidateState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getCandidateState() {
        return candidateState;
    }

    public void setCandidateState(String candidateState) {
        this.candidateState = candidateState;
    }


}
