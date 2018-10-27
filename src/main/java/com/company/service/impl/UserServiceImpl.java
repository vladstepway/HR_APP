package com.company.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.model.User;
import com.company.dao.UserDao;
import com.company.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    public List<User> getSortedUsersBySurname( ){ return userDao.getSortedUsersBySurname(); }
    public List<User> getSortedUsersDESCsurname( ){ return userDao.getSortedUsersDESCsurname(); }
    public List<User> getSortedUsersByName( ){ return userDao.getSortedUsersByName(); }
    public List<User> getSortedUsersDESCname( ){ return userDao.getSortedUsersDESCname(); }
    public List<User> getSortedUsersByID( ){ return userDao.getSortedUsersByID(); }
    public List<User> getSortedUsersDESCid( ){ return userDao.getSortedUsersDESCid(); }
    public List<String> getDeveloperId(){return userDao.getDeveloperId();}
    public List<String> getInterviewerId(){return userDao.getInterviewerId();}
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

}