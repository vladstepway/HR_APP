package com.company.dao;

import java.util.List;

import com.company.model.User;

public interface UserDao extends GenericDao<User, Integer> {

    User getByPK(Integer id);

    List<User> getAll();

    List<User> getSortedUsersBySurname();

    List<User> getSortedUsersByName();

    List<User> getSortedUsersByID();

    List<User> getSortedUsersDESCsurname();

    List<User> getSortedUsersDESCname();

    List<User> getSortedUsersDESCid();

    List<String> getDeveloperId();

    List<String> getInterviewerId();

    int create(User user);

    int update(User user);

    int delete(Integer id);
}
