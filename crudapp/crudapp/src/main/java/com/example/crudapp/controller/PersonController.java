package com.example.crudapp.controller;

import com.example.crudapp.model.Person;
import com.example.crudapp.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody Person person) {
        person.setId(id);
        personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }
}
