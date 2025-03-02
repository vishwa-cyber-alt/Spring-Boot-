package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    public boolean login(String name, String email) {
        try {
            Person person = personRepository.findByNameAndEmail(name, email);
            return person != null;  // If a person is found, return true
        } catch (Exception e) {
            return false;  // If an exception occurs (no record found), return false
        }
    }
    public Person GetidByName(String name) {
        return personRepository.GetidByName(name);
    }
}
