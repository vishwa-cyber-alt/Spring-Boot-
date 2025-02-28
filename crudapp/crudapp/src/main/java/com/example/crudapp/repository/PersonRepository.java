package com.example.crudapp.repository;

import com.example.crudapp.model.Person;
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

    public Person findById(int id) {
        String sql = "SELECT * FROM Person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setEmail(rs.getString("email"));
            return person;
        });
    }

    public void save(Person person) {
        String sql = "INSERT INTO Person (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, person.getName(), person.getEmail());
    }

    public void update(Person person) {
        String sql = "UPDATE Person SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getName(), person.getEmail(), person.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Person WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
