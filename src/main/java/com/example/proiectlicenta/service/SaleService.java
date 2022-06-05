package com.example.proiectlicenta.service;

import com.example.proiectlicenta.entity.Client;
import com.example.proiectlicenta.entity.Sale;
import com.example.proiectlicenta.entity.StatusSale;
import com.example.proiectlicenta.entity.Task;
import com.example.proiectlicenta.repository.ClientRepository;
import com.example.proiectlicenta.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
       SaleRepository saleRepository;
    ClientRepository clientRepository;
    @Autowired
    public SaleService(SaleRepository saleRepository, ClientRepository clientRepository) {
        this.saleRepository = saleRepository;
        this.clientRepository = clientRepository;
    }

    public List<Sale> getSales(){
        return saleRepository.findAll();
    }
    public Optional<Sale> getSale(Long id){ return saleRepository.findSaleById(id);
    }
    public void addNewSale(Sale sale){
        saleRepository.save(sale);
    }

    public void setClient(Sale sale, Long id) {
        Client client=clientRepository.findClientById(id).get();
        sale.setClient(client);
    }

    public Sale getSaleById(Long saleId) {
        return saleRepository.findSaleById(saleId).get();
    }
    public void updateSale (Sale sale){saleRepository.save(sale);}
    public List<Sale> getSalesByStatus(StatusSale statusSale){
         return saleRepository.findAllByStatus(statusSale);
    }
    public List<Sale> getSalesByClient(Client client){
        return saleRepository.findAllByClient(client);
    }

}
