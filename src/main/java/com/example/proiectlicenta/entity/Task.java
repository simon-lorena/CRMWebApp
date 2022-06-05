package com.example.proiectlicenta.entity;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity(name="Task")
@Table(name="Task")
public class Task {
    @Id
    @SequenceGenerator(name="task_sequence", allocationSize = 1, sequenceName = "task_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @Column(
            name="id",
            updatable = false
    )
    private long id;
    @Column(
            name="name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name="description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(
            name="dateOfRegistration",
            columnDefinition = "DATE"
    )
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration= new Date();
    @Column(
            name="deadline",
            nullable = false,
            columnDefinition = "DATE"
    )
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Column(
            name="status"
    )
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sale_id")
    private Sale sale;
    public Task() {
    }

    public Task(long id, String name, String description, Date deadline, Status status, Employee employee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateOfRegistration = new Date();
        this.deadline = deadline;
        this.status = status;
        this.employee = employee;
    }

    public Task(String name, String description, Date deadline, Status status, Employee employee, Sale sale) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.employee = employee;
        this.sale = sale;
    }

    public Task(String name, String description, Date deadline, Status status, Employee employee) {
        this.name = name;
        this.description = description;
        this.dateOfRegistration =new Date();
        this.deadline = deadline;
        this.status = status;
        this.employee = employee;
    }

    public Task(String name, String description, Date deadline) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public void setId(long id) {
        this.id = id;
    }
}

