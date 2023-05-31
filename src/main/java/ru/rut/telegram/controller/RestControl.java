package ru.rut.telegram.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import ru.rut.telegram.Model.Employee;
import ru.rut.telegram.Model.Work;
import ru.rut.telegram.Repo.EmployeeRepo;
import ru.rut.telegram.Repo.WorkRepo;

import java.util.Date;

@RestController
public class RestControl{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private WorkRepo workRepo;



    @GetMapping("/work")
    public String work(String username){
        Work work =new Work();
        Employee employee = employeeRepo.findByLogin(username);
        Date date = new Date();
        work.setEmployee(employee);
        work.setStartDate(date);
        workRepo.save(work);
        return "Игра сохранена";
    }
    @PostMapping("/region-list")
    public String region_list(){
        return "0";
    }

}
