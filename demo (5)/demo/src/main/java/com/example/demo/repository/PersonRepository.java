package com.example.demo.repository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        String sql = "SELECT * FROM Person";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setEmail(rs.getString("email"));
            return person;
        });
    }


    public Person findByNameAndEmail(String name, String email) {
        String sql = "SELECT * FROM Person WHERE name = ? AND email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name, email}, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setEmail(rs.getString("email"));
            return person;
        });
    }
    public Person GetidByName(String name) {
        String sql = "SELECT id FROM Person WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            return person;
        });
    }

}
