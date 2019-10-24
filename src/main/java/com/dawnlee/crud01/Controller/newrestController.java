package com.dawnlee.crud01.Controller;

import com.dawnlee.crud01.Bean.Employee;
import com.dawnlee.crud01.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class newrestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getemplist")
    public List<Employee> getemp(){

        List<Employee> listall = employeeService.listall();

        return listall;
    }
}
