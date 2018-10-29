package com.company.model.mapper;

import com.company.model.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VacancyRowMapper implements RowMapper<Vacancy> {

    @Override
    public Vacancy mapRow(ResultSet resultSet, int row) throws SQLException {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(resultSet.getInt("id"));
        vacancy.setPosition(resultSet.getString("position"));
        vacancy.setSalaryFrom(resultSet.getDouble("salary_from"));
        vacancy.setSalaryTo(resultSet.getDouble("salary_to"));
        vacancy.setVacancyState(resultSet.getString("vacancy_state"));
        vacancy.setExperienceYearsRequire(resultSet.getDouble("experience_years_require"));
        vacancy.setCreatorId(resultSet.getInt("developer_id"));
        return vacancy;
    }
}
