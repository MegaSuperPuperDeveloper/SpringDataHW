package com.example.springdatahw.controllers;

import com.example.springdatahw.models.Person;
import com.example.springdatahw.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public Iterable<Person> getAllPeople() {
        return personService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping("/add/{name}/{age}")
    public void addPerson(@PathVariable String name, @PathVariable int age) {
        personService.create(name, age);
        getAllPeople();
    }

    @DeleteMapping("/del/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
        getAllPeople();
    }

    @PutMapping("/update/{id}/{name}/{age}")
    public void updatePerson(@PathVariable Long id, @PathVariable String name, @PathVariable int age) {
        personService.updateById(id, name, age);
        getAllPeople();
    }

}