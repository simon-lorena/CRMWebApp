package com.example.proiectlicenta.repository;

import com.example.proiectlicenta.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{
    Optional<Client> findClientByCUI(Long CUI);
    Optional<Client> findClientById( Long id);
}
