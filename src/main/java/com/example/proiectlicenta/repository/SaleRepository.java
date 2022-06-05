package com.example.proiectlicenta.repository;

import com.example.proiectlicenta.entity.Client;
import com.example.proiectlicenta.entity.Sale;
import com.example.proiectlicenta.entity.StatusSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    Optional<Sale> findSaleById(Long id);
    List<Sale> findAllByStatus(StatusSale status);
    List<Sale> findAllByClient(Client client);

}
