package com.example.springdatahw.services;

import com.example.springdatahw.models.Person;
import com.example.springdatahw.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public void create(String name, int age) {
        personRepository.create(name, age);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public void updateById(Long id, String name, int age) {
        personRepository.updateById(id, name, age);
    }

}