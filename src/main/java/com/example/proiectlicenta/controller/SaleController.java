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
public class SaleController {
    private final ClientService clientService;
    private final PersonService personService;
    private final TaskService taskService;
    private final EmployeeService employeeService;
    private final SaleService saleService;
    @Autowired
    public SaleController(ClientService clientService, PersonService personService,TaskService taskService, EmployeeService employeeService, SaleService saleService) {
        this.personService=personService;
        this.clientService = clientService;
        this.taskService= taskService;
        this.employeeService=employeeService;
        this.saleService=saleService;
    }
    @GetMapping(path="/sales")
    public ModelAndView showSales(){
        ModelAndView modelAndView= new ModelAndView("show-sales");
        List<Sale> sales= saleService.getSales();
        modelAndView.addObject("sales",sales);
        return modelAndView;
    }
    @GetMapping(path="/sales/{Id}")
    public ModelAndView showSale(@PathVariable long Id){
        ModelAndView modelAndView= new ModelAndView("show-sale");
        Optional<Sale> sale = saleService.getSale(Id);
        List<Task> tasks=taskService.getTasksBySale(sale.get());
        if (sale.isPresent())
            modelAndView.addObject("sale", sale.get());
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }
    @GetMapping ("/addSale")
    public ModelAndView addSale(){
        ModelAndView modelAndView=new ModelAndView("add-sale-form");
        Sale sale=new Sale();
        List<Client> clients=clientService.getClients();
        modelAndView.addObject("clients", clients);
        modelAndView.addObject("sale",sale);
        return modelAndView;
    }
    @PostMapping("/sales/saveSale")
    public RedirectView saveSale(@ModelAttribute Sale sale, @RequestParam Long clientId){
        saleService.setClient(sale, clientId);
        saleService.addNewSale(sale);
        return new RedirectView("/sales");

    }
    @GetMapping("/sales/updateSale")
    public ModelAndView updateSale(@RequestParam Long saleId ){
        ModelAndView modelAndView= new ModelAndView("update-sale");
        Sale sale=saleService.getSaleById(saleId);
        modelAndView.addObject("sale", sale);
        List<Client> clients=clientService.getClients();
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }
    @PostMapping("/sales/updateSale/save")
    public RedirectView saveUpdatedSale(@ModelAttribute Sale sale, @RequestParam Long id,  @RequestParam Long saleId)
    {
        sale.setId(saleId);
        saleService.setClient(sale, id);
        saleService.updateSale(sale);
        return new RedirectView("/sales");
    }
    @GetMapping("/sales/{Id}/tasks/addTaskForm")
    public ModelAndView addTaskFormSale(){
        ModelAndView modelAndView= new ModelAndView("add-task-form-sale");
        Task task=new Task();
        List<Employee> employees=employeeService.getEmployees();
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("task", task);
        return modelAndView;
    }
    @PostMapping("/sales/{idSale}/tasks/addTaskForm/saveTaskSale")
    public RedirectView registerNewTaskSale(@ModelAttribute Task task,  @RequestParam Long employeeId, @PathVariable Long idSale)
    {

        taskService.setEmployee(task, employeeId);
        taskService.setSale(task,idSale);
        taskService.addNewTask(task);
        return new RedirectView("/sales/"+idSale);
    }
    @GetMapping("/sales/{idSale}/tasks/updateTask")
    public ModelAndView updateTaskFromSale(@RequestParam Long taskId ){
        ModelAndView modelAndView= new ModelAndView("update-task-from-sale");
        Task task = taskService.getTaskById(taskId).get();
        modelAndView.addObject("task", task);
        List<Employee> employees=employeeService.getEmployees();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @PostMapping("/sales/tasks/updateTask/save")
    public RedirectView saveUpdatedTaskFromSale(@ModelAttribute Task task, @RequestParam Long employeeId,  @RequestParam Long taskId, @RequestParam Long saleId)
    {
        task.setId(taskId);
        taskService.setEmployee(task, employeeId);
        taskService.setSale(task, saleId);
        taskService.updateTask(task);
        return new RedirectView("/sales/"+saleId);

    }
}
