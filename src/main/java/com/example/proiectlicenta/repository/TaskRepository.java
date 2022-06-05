package com.example.proiectlicenta.repository;

import com.example.proiectlicenta.entity.Sale;
import com.example.proiectlicenta.entity.Status;
import com.example.proiectlicenta.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Long countAllByStatus(Status status);
    List<Task> findAllBySale(Sale sale);
    List<Task> findAllByStatus(Status status);
}
