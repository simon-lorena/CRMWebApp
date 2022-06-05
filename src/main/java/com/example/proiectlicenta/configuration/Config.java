package com.example.proiectlicenta.configuration;

import com.example.proiectlicenta.entity.*;
import com.example.proiectlicenta.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class Config {
    /*  @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository, PersonRepository personRepository, TaskRepository taskRepository, EmployeeRepository employeeRepository, SaleRepository saleRepository) {
         return args -> {
           Person person1 = new Person("Marian", "Popescu", "marian.popescu@gmail.com", "0720302913", Department.Marketing);
             Person person2 = new Person("Miruna", "Georgescu", "miruna.gerogescu@gmail.com", "0720352913", Department.Vanzari);
             personRepository.saveAll(List.of(person1, person2));

             Client client1 = new Client(1236545L, "Accenture SRL", "www.accenture.com", person1);
             Client client2 = new Client(4636545L, "KPMG SRL",  "www.kpmg.com", person2);
             clientRepository.saveAll(List.of(client1, client2));

            DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
            Employee employee1= new Employee("Maria", "Popescu", df.parse("12-12-1999"),df.parse("09-03-2020"),"maria.popescu@gmail.com","0722675640");
            Employee employee2= new Employee("Silviu", "Cristea", df.parse("02-09-1999"),df.parse("09-04-2019"),"s.cristea@gmail.com","0737063027");
            Employee employee3= new Employee("Sandra", "Isac", df.parse("02-03-1986"),df.parse("09-04-2013"),"s.isac@gmail.com","0737063027");
            Employee employee4= new Employee("Andrei", "Severin", df.parse("12-04-1989"),df.parse("09-04-2016"),"severin.andrei@gmail.com","0737063027");
            Employee employee5= new Employee("Loredana", "Lungu", df.parse("16-12-1984"),df.parse("12-03-2008"),"lorena.lungu@gmail.com","0737063027");


            employeeRepository.saveAll(List.of(employee1, employee2, employee3, employee4, employee5));

            Sale sale1= new Sale("Vanzare noua", "Vanzare descriere", StatusSale.Câștigată, client1);
            Sale sale2= new Sale("Vanzare noua 2", "Vanzare descriere 2", StatusSale.Curentă, client2);
            saleRepository.saveAll(List.of(sale1, sale2));

            Task task1=new Task( "Contactare client","Contactare client KPMG cu privire la vanzarea de produse din comanda",df.parse("30-09-2022"),Status.Finalizata,employee1, sale2);
            Task task2=new Task("Contactare client","Contactare client Accenture cu privire la vanzarea de produse din comanda 732",df.parse("30-12-2022"),Status.Finalizata,employee1, sale1);
            Task task3=new Task("Semnare contract","Semnare contract de livrare marfuri client Accenture ",df.parse("30-12-2022"),Status.Curenta,employee2, sale1);
            Task task4=new Task("Trimite oferta","De trimis oferta pentru lista de clienti ",df.parse("12-12-2022"),Status.Curenta,employee2);

            taskRepository.saveAll(List.of(task1, task2, task3, task4));


        };
    }

    ;*/

            }
