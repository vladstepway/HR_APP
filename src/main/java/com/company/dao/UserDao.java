package com.company.dao;

import java.util.List;

import com.company.model.User;

public interface UserDao {

    User getUser(int id);

    List<User> getAllUsers();

    List<User> getSortedUsersBySurname();
    List<User> getSortedUsersByName();
    List<User> getSortedUsersByID();

    List<User> getSortedUsersDESCsurname();
    List<User> getSortedUsersDESCname();
    List<User> getSortedUsersDESCid();

    List<String> getDeveloperId();

    List<String> getInterviewerId();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
