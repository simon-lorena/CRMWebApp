package com.example.proiectlicenta.service;

import com.example.proiectlicenta.entity.Person;
import com.example.proiectlicenta.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public void addNewPerson(Person person){
        personRepository.save(person);
    }
    public void updatePerson( Person person){
        personRepository.save(person);
    }
}
