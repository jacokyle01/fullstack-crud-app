package com.tennis.match10s.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/people")
    List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @GetMapping("/people/{id}")
    Person getPerson(@PathVariable int id) {
        return personRepository.findById(id);
    }

    @PostMapping("/people")
    String addPerson(@RequestBody Person person) {
        if (person == null) {
            return "failure";
        }

        personRepository.save(person);
        return "success";
    }

}
