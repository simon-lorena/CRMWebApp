package com.example.proiectlicenta.controller;

import com.example.proiectlicenta.entity.*;
import com.example.proiectlicenta.repository.TaskRepository;
import com.example.proiectlicenta.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ClientController {
    private final ClientService clientService;
    private final PersonService personService;
    private final TaskService taskService;
    private final EmployeeService employeeService;
    private final SaleService saleService;
    @Autowired
    public ClientController(ClientService clientService, PersonService personService,TaskService taskService, EmployeeService employeeService, SaleService saleService) {
        this.personService=personService;
        this.clientService = clientService;
        this.taskService= taskService;
        this.employeeService=employeeService;
        this.saleService=saleService;
    }

    @GetMapping(path="/home")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView= new ModelAndView("home");
        List<Task> tasks=taskService.getTasksByStatus(Status.Curenta);
        List<Sale> sales=saleService.getSalesByStatus(StatusSale.Curentă);
        modelAndView.addObject("currentTasks", tasks);
        modelAndView.addObject("currentSales", sales);

        return modelAndView;
    }


 @GetMapping(path="/clients")
 public ModelAndView showClients(){
        ModelAndView modelAndView= new ModelAndView("show-clients");
        List<Client> clients= clientService.getClients();
        modelAndView.addObject("clients",clients);
        return modelAndView;
   }
    @GetMapping("clients/{Id}")
    public ModelAndView showClient(@PathVariable long Id){
        ModelAndView modelAndView= new ModelAndView("show-client");
        Optional<Client> client = clientService.getClient(Id);
        if (client.isPresent())
            modelAndView.addObject("client", client.get());
        List<Sale> sales= saleService.getSalesByClient(client.get());
        modelAndView.addObject("sales", sales);
        return modelAndView;
    }
    @GetMapping("/clients/{clientId}/updateSale")
    public ModelAndView updateSaleForClient(@RequestParam Long saleId ){
        ModelAndView modelAndView= new ModelAndView("update-sale-for-client");
        Sale sale=saleService.getSaleById(saleId);
        modelAndView.addObject("sale", sale);
        return modelAndView;
    }
    @PostMapping("/clients/{clientId}/save")
    public RedirectView saveUpdatedSaleForClient(@ModelAttribute Sale sale, @PathVariable Long clientId,   @RequestParam Long saleId)
    {
        sale.setId(saleId);
        saleService.setClient(sale, clientId);
        saleService.updateSale(sale);
        return new RedirectView("/clients/"+clientId);
    }

    @GetMapping ("/clients/{clientId}/addSaleForClient")
    public ModelAndView addSaleForClient(){
        ModelAndView modelAndView=new ModelAndView("add-sale-for-client-form");
        Sale sale=new Sale();
        modelAndView.addObject("sale",sale);
        return modelAndView;
    }
    @PostMapping("/clients/{clientId}/addSaleForClient/save")
    public RedirectView saveSaleForClient(@ModelAttribute Sale sale, @PathVariable Long clientId){
        saleService.setClient(sale, clientId);
        saleService.addNewSale(sale);
        return new RedirectView("/clients/"+clientId);

    }
   @GetMapping("clients/addClientForm")
   public ModelAndView addClientForm(){
    ModelAndView modelAndView= new ModelAndView("add-client-form");
       Client client=new Client();
       Person person=new Person();
       modelAndView.addObject("client", client);
       modelAndView.addObject("person",person);
       return modelAndView;
   }

    @PostMapping("clients/saveClient")
    public RedirectView registerNewClient(@ModelAttribute Client client, @ModelAttribute  Person person)
    {
    clientService.addNewClient(client);
    personService.addNewPerson(person);
    clientService.setPerson(client, person);

        return new RedirectView("/clients");
    }



    @GetMapping("/clients/updateClient")
    public ModelAndView updateClient(@RequestParam Long clientId ){
        ModelAndView modelAndView= new ModelAndView("update-client");
        Client client=clientService.getClient(clientId).get();
        modelAndView.addObject("client", client);
        Person person=client.getPerson();
        modelAndView.addObject("person", person);
        return modelAndView;
    }
    @PostMapping("/clients/updateClient/save")
    public RedirectView saveUpdatedClient(@ModelAttribute Client client, @RequestParam Long personId, @ModelAttribute Person person,  @RequestParam Long clientId)
    {
        client.setId(clientId);
        person.setId(personId);
        clientService.setPerson(client, person);
        personService.updatePerson(person);
        clientService.updateClient(client);
        return new RedirectView("/clients");
    }


}

