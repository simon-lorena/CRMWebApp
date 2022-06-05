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
public class TaskController {
    private final ClientService clientService;
    private final PersonService personService;
    private final TaskService taskService;
    private final EmployeeService employeeService;
    private final SaleService saleService;
    @Autowired
    public TaskController(ClientService clientService, PersonService personService,TaskService taskService, EmployeeService employeeService, SaleService saleService) {
        this.personService=personService;
        this.clientService = clientService;
        this.taskService= taskService;
        this.employeeService=employeeService;
        this.saleService=saleService;
    }
    @GetMapping(path="/tasks")
    public ModelAndView showtasks(){
        ModelAndView modelAndView= new ModelAndView("show-tasks");
        List<Task> tasks= taskService.getTasks();
        Long finishedTasks =taskService.getNrOfFinalisedTasks();
        Long unfinishedTasks=taskService.getNrOfUnFinalisedTasks();
        Long delayedTasks=taskService.getNrOfDelayedTasks();
        Long currentTasks=taskService.getNrOfCurrentTasks();
        modelAndView.addObject("tasks",tasks);
        modelAndView.addObject("finishedTasks", finishedTasks);
        modelAndView.addObject("unfinishedTasks", unfinishedTasks);
        modelAndView.addObject("delayedTasks", delayedTasks);
        modelAndView.addObject("currentTasks", currentTasks);

        return modelAndView;
    }
    @GetMapping("tasks/updateTask")
    public ModelAndView updateTask(@RequestParam Long taskId ){
        ModelAndView modelAndView= new ModelAndView("update-task");
        Task task = taskService.getTaskById(taskId).get();
        modelAndView.addObject("task", task);
        List<Employee> employees=employeeService.getEmployees();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @PostMapping("tasks/updateTask/save")
    public RedirectView saveUpdatedTask(@ModelAttribute Task task, @RequestParam Long id,  @RequestParam Long taskId)
    {
        task.setId(taskId);
        taskService.setEmployee(task, id);
        taskService.updateTask(task);
        return new RedirectView("/tasks");

    }
    @GetMapping("/tasks/addTaskForm")
    public ModelAndView addTaskForm(){
        ModelAndView modelAndView= new ModelAndView("add-task-form");
        Task task=new Task();
        List<Employee> employees=employeeService.getEmployees();
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("task", task);
        return modelAndView;
    }
    @PostMapping("/tasks/addTaskForm/saveTask")
    public RedirectView registerNewTask(@ModelAttribute Task task,  @RequestParam Long employeeId)
    {

        taskService.setEmployee(task, employeeId);
        taskService.addNewTask(task);
        return new RedirectView("/tasks");
    }
}
