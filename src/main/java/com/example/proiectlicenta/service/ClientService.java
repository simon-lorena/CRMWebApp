package com.example.proiectlicenta.service;

import com.example.proiectlicenta.entity.Client;
import com.example.proiectlicenta.entity.Employee;
import com.example.proiectlicenta.entity.Person;
import com.example.proiectlicenta.repository.ClientRepository;
import com.example.proiectlicenta.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, PersonRepository personRepository) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public Optional<Client> getClient(Long id){
        return clientRepository.findById(id);
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional= clientRepository.findClientByCUI(client.getCUI());

        if(clientOptional.isPresent()){
            throw new IllegalStateException("CUI taken");
        }
        clientRepository.save(client);
    }
    public void setPerson(Client client, Person person){
        client.setPerson(person);
        clientRepository.save(client);

    }
    public void setPersonById(Client client, Long personId){
        Person person;
        person=personRepository.findById(personId).get();
        client.setPerson(person);

    }
    public void deleteClient(Long clientId) {
        boolean exists=clientRepository.existsById(clientId);
        if(!exists)  {
            throw new IllegalStateException("client with id "+clientId+"doesn't exist");
        }
        clientRepository.deleteById(clientId);

    }
    @Transactional
    public void updateClient(Client client) {
        clientRepository.save(client);
    }
}
