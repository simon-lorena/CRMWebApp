package com.example.proiectlicenta.service;

import com.example.proiectlicenta.entity.Employee;

import com.example.proiectlicenta.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
public List<Employee> getEmployees(){
        return employeeRepository.findAll();
}
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return employeeRepository.findByEmail(email)
               .orElseThrow(()->new UsernameNotFoundException("user not found"));

        }

}
