package com.example.proiectlicenta.service;

import com.example.proiectlicenta.entity.Employee;
import com.example.proiectlicenta.entity.Sale;
import com.example.proiectlicenta.entity.Status;
import com.example.proiectlicenta.entity.Task;
import com.example.proiectlicenta.repository.EmployeeRepository;
import com.example.proiectlicenta.repository.SaleRepository;
import com.example.proiectlicenta.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;
    private SaleRepository saleRepository;
        @Autowired
    public TaskService(TaskRepository taskRepository,EmployeeRepository employeeRepository, SaleRepository saleRepository) {
            this.employeeRepository = employeeRepository;
            this.taskRepository = taskRepository;
            this.saleRepository=saleRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    public List<Task> getTasksBySale(Sale sale) { return taskRepository.findAllBySale(sale);}
    public List<Task> getTasksByStatus(Status status) {
            return taskRepository.findAllByStatus(status);}
    public Optional<Task> getTaskById(Long id){
            return taskRepository.findById(id);
    }

    public void setEmployee(Task task, Long id){
            Optional<Employee> employee;
            employee=employeeRepository.findById(id);
            task.setEmployee(employee.get());

    }
    public void setSale(Task task, Long id){
        Optional<Sale> sale;
        sale=saleRepository.findSaleById(id);
        task.setSale(sale.get());
    }

    public Long getNrOfFinalisedTasks(){
            Long nr= taskRepository.countAllByStatus(Status.Finalizata);
            return nr;
    }
    public Long getNrOfUnFinalisedTasks(){
        Long nr= taskRepository.countAllByStatus(Status.Neindeplinita);
        return nr;
    }
    public Long getNrOfDelayedTasks(){
        Long nr= taskRepository.countAllByStatus(Status.Amanata);
        return nr;
    }
    public Long getNrOfCurrentTasks(){
        Long nr= taskRepository.countAllByStatus(Status.Curenta);
        return nr;
    }
    public void addNewTask( Task task){
            taskRepository.save(task);
    }
    public void updateTask (Task task){taskRepository.save(task);}
}
