package com.example.proiectlicenta.entity;

import jakarta.persistence.*;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Entity(name="Person")
@Table(name="Person")
public class    Person  {
    @Id
    @SequenceGenerator(
            name="person_sequence", sequenceName = "person_sequence", allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "person_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="firstName",
            columnDefinition = "TEXT",
            nullable = false
    )
    private  String firstName;
    @Column(
            name="lastName",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String lastName;
    @Column(
            name="email",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String email;
    @Column(
            name="telephone",
            columnDefinition = "TEXT"
    )
    private String telephone;
    @Column(
            name="department"
    )
    @Enumerated(EnumType.STRING)
    private Department department;

    public Person(Long id,  String firstName, String lastName, String email, String telephone, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.department = department;
    }
    public Person(Long id,  String firstName, String lastName, String email, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }


    public Person(String firstName, String lastName, String email, String telephone, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.department = department;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", department=" + department +
                '}';
    }


}
