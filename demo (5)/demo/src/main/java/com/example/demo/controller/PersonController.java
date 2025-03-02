package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Get all persons (for your reference)
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // Login API: Check if name and email exist in the database
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Person person) {
        // Check if the person with the given name and email exists in the database
        boolean exists = personService.login(person.getName(), person.getEmail());

        if (exists) {
            // If the person exists, return a success message
            return ResponseEntity.ok("Login successful! Redirecting...");
        } else {
            // If not, return a failure message
            return ResponseEntity.status(401).body("Invalid credentials. Login failed.");
        }
    }

    @GetMapping("/get-id/{name}")
    public ResponseEntity<Person> getUserId(@PathVariable String name) {
        // Retrieve user ID based on the name
        Person person = personService.GetidByName(name);

        if (person != null) {
            // Return the person object containing the ID
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.status(404).body(null); // If person is not found
        }
    }
}
