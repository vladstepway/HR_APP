package com.company.dao.impl;

import com.company.dao.UserDao;
import com.company.model.User;
import com.company.model.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public User getByPK(Integer id) {
        return jdbcTemplate.queryForObject("select * from user where id = ?",
                new Object[]{id}, new UserRowMapper());
    }

    @Transactional
    public List<User> getAll() {
        return jdbcTemplate.query("select * from user",
                new UserRowMapper());
    }

    public List<User> getSortedUsersBySurname() {
        return jdbcTemplate.query("select * from user order by surname",
                new UserRowMapper());
    }

    public List<User> getSortedUsersDESCsurname() {
        return jdbcTemplate.query("select * from user order by surname desc",
                new UserRowMapper());
    }

    public List<User> getSortedUsersByName() {
        return jdbcTemplate.query("select * from user order by name",
                new UserRowMapper());
    }

    public List<User> getSortedUsersDESCname() {
        return jdbcTemplate.query("select * from user order by name desc",
                new UserRowMapper());
    }

    public List<User> getSortedUsersByID() {
        return jdbcTemplate.query("select * from user order by id",
                new UserRowMapper());
    }

    public List<User> getSortedUsersDESCid() {
        return jdbcTemplate.query("select * from user order by id desc",
                new UserRowMapper());
    }

    @Transactional
    public List<String> getDeveloperId() {
        return jdbcTemplate.queryForList("select id from user ",
                String.class);
    }

    @Transactional
    public List<String> getInterviewerId() {
        return jdbcTemplate.queryForList("select id from user where user_role = 'interviewer'",
                String.class);
    }

    @Transactional
    public int create(User user) {
        return jdbcTemplate.update("insert into user (name,surname,email," +
                        "password,user_role)" +
                        " values (?, ?, ?, ?,?)",
                user.getFirstName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getUserRole());
    }

    @Transactional
    public int update(User user) {
        return jdbcTemplate.update("update user set name = ?, surname = ?, email = ?, " +
                        "password = ?, user_role = ? where id = ?",
                user.getFirstName(), user.getSurname(),
                user.getEmail(), user.getPassword(),
                user.getUserRole(),
                user.getId());
    }

    @Transactional
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from user where id = ?", id);
    }


}