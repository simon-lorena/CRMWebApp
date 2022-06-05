package com.example.proiectlicenta.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
@Entity (name="Employee")
@Table( name="Employee")

public class Employee  implements UserDetails {
    @Id
    @SequenceGenerator(name="employee_sequence", allocationSize = 1, sequenceName = "employee_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
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
    private String firstName;
    @Column(
            name="lastName",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String lastName;
    @Column(
            name="dateOfBirth",
            columnDefinition = "DATE"
    )
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(
            name="hireDate",
            columnDefinition = "DATE"
    )
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(
            name="email",
            columnDefinition = "TEXT"

    )
    private String email;
    @Column(
            name="telephone",
            columnDefinition = "TEXT"

    )
    private String telephone;
    private String password;
    private Boolean locked= false;
    private Boolean enabled = false;

    public Employee() {
    }

    public Employee(String firstName, String lastName,  String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

    public Employee(String firstName, String lastName, Date dateOfBirth, Date hireDate, String email, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hireDate = hireDate;
        this.email = email;
        this.telephone = telephone;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
