package com.example.proiectlicenta.repository;

import com.example.proiectlicenta.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PersonRepository extends JpaRepository<Person, Long> {
}
