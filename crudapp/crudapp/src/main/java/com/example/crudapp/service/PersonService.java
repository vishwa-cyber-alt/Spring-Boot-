package com.example.crudapp.service;

import com.example.crudapp.model.Person;
import com.example.crudapp.repository.PersonRepository;
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

    public Person getPersonById(int id) {
        return personRepository.findById(id);
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(Person person) {
        personRepository.update(person);
    }

    public void deletePerson(int id) {
        personRepository.delete(id);
    }
}
