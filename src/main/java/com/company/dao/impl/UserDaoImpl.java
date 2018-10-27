package com.company.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.User;
import com.company.model.mapper.UserRowMapper;
import com.company.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public User getUser(int id) {
        User user = jdbcTemplate.queryForObject("select * from user where id = ?",
                new Object[] { id }, new UserRowMapper());
        return user;
    }
    @Transactional
    public List<User> getAllUsers() {
        List<User> user = jdbcTemplate.query("select * from user",
                new UserRowMapper());
        return user;
    }
    public List<User> getSortedUsersBySurname(){
        List<User> user = jdbcTemplate.query("select * from user order by surname",  new UserRowMapper());
        return user;
    }
    public List<User> getSortedUsersDESCsurname(){
        List<User> user = jdbcTemplate.query("select * from user order by surname desc",  new UserRowMapper());
        return user;
    }

    public List<User> getSortedUsersByName(){
        List<User> user = jdbcTemplate.query("select * from user order by name",  new UserRowMapper());
        return user;
    }
    public List<User> getSortedUsersDESCname(){
        List<User> user = jdbcTemplate.query("select * from user order by name desc",  new UserRowMapper());
        return user;
    }

    public List<User> getSortedUsersByID(){
        List<User> user = jdbcTemplate.query("select * from user order by id",  new UserRowMapper());
        return user;
    }
    public List<User> getSortedUsersDESCid(){
        List<User> user = jdbcTemplate.query("select * from user order by id desc",  new UserRowMapper());
        return user;
    }
    @Transactional
    public List<String> getDeveloperId(){
        return jdbcTemplate.queryForList("select id from user ", String.class);
    }
    @Transactional
    public List<String> getInterviewerId(){
        return jdbcTemplate.queryForList("select id from user where user_role = 'interviewer'", String.class);
    }
    @Transactional
    public int addUser(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(4);
        parameters.put("name", user.getFirstName());
        parameters.put("surname", user.getSurname());
        parameters.put("email", user.getEmail());
        parameters.put("password", user.getPassword());
        parameters.put("user_role", user.getUserRole());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateUser(User user) {
        String sql = "update user set name = ?, surname = ?, email = ?, password = ?, user_role = ? where id = ?";
        int resp = jdbcTemplate.update(sql,
                user.getFirstName(), user.getSurname(),
                user.getEmail(), user.getPassword(),
                user.getUserRole(),
                user.getId());
        return resp;
    }

    @Transactional
    public int deleteUser(int id) {
        return jdbcTemplate.update("delete from user where id = ?", id);
    }


}