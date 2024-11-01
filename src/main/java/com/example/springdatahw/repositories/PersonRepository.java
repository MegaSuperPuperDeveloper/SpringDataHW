package com.example.springdatahw.repositories;

import com.example.springdatahw.models.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("SELECT * FROM person;")
    List<Person> findAll();

    @Query("SELECT * FROM person WHERE id = :id;")
    Optional<Person> findById(Long id);

    @Modifying
    @Query("INSERT INTO person (name, age) VALUES (:name, :age)")
    void create(String name, int age);

    @Modifying
    @Query("UPDATE person SET age = :age, name = :name WHERE id = :id")
    void updateById(Long id, String name, int age);

    @Modifying
    @Query("DELETE FROM person WHERE id = :id")
    void deleteById(Long id);
}