package com.company.dao.impl;

import com.company.dao.VacancyDao;
import com.company.model.Vacancy;
import com.company.model.mapper.VacancyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class VacancyDaoImpl implements VacancyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Vacancy getByPK(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM vacancy WHERE id = ?",
                new Object[]{id}, new VacancyRowMapper());
    }

    @Transactional
    public List<Vacancy> getAll() {
        return jdbcTemplate.query("SELECT * FROM vacancy",
                new VacancyRowMapper());
    }

    public List<String> getAllVacancyID() {
        return jdbcTemplate.queryForList("select id from vacancy", String.class);
    }

    @Override
    public List<String> getAllVacancyPosition() {
        return jdbcTemplate.queryForList("select position from vacancy", String.class);
    }

    @Transactional
    public int create(Vacancy vacancy) {
        return jdbcTemplate.update("insert into vacancy (position,salary_from,salary_to," +
                        "vacancy_state,experience_years_require,developer_id) values (?,?,?,?,?,?)",
                vacancy.getPosition(), vacancy.getSalaryFrom(), vacancy.getSalaryTo(),
                vacancy.getVacancyState(), vacancy.getExperienceYearsRequire(),
                vacancy.getCreatorId());
    }

    @Transactional
    public int update(Vacancy vacancy) {
        return jdbcTemplate.update("UPDATE vacancy SET " +
                        "position = ?," +
                        " salary_from = ?," +
                        " salary_to = ?, " +
                        "vacancy_state = ?," +
                        "experience_years_require = ?," +
                        "developer_id = ?," +
                        " where id = ?",
                vacancy.getPosition(),
                vacancy.getSalaryFrom(),
                vacancy.getSalaryTo(),
                vacancy.getVacancyState(),
                vacancy.getExperienceYearsRequire(),
                vacancy.getCreatorId(),
                vacancy.getId());
    }

    @Transactional
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM vacancy WHERE id = ?", id);
    }
}
