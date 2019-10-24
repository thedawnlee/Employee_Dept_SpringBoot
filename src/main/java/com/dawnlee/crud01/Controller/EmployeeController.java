package com.dawnlee.crud01.Controller;

import com.dawnlee.crud01.Bean.Department;
import com.dawnlee.crud01.Bean.DeptAndEmp;
import com.dawnlee.crud01.Bean.Employee;
import com.dawnlee.crud01.Service.DepartmentService;
import com.dawnlee.crud01.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;


    @GetMapping("/emps")
    public String golist(Model model){


        List<DeptAndEmp> deptAndEmps = new ArrayList<>();

        List<Employee> listall = employeeService.listall();

        for(int i = 0;i<listall.size();i++){

            DeptAndEmp deptAndEmp = new DeptAndEmp();

            Employee employee = listall.get(i);

            Department department = departmentService.getdeptName(employee.getdId());

            deptAndEmp.setDepartment(department);
            deptAndEmp.setEmployee(employee);
            deptAndEmps.add(deptAndEmp);


        }
        model.addAttribute("d_e_list",deptAndEmps);

//        List<Employee> listall = employeeService.listall();
//
//        model.addAttribute("emp_list",listall);


        return "list";

    }

    @GetMapping("/emp/{id}")
    public String gomodfiy(
            @PathVariable("id") Integer id,
            Model model){


        List<Department> listall = departmentService.listall();
        Employee employee = employeeService.findbyId(id);

        model.addAttribute("emp",employee);
        model.addAttribute("dept_list",listall);
        return "add";


    }

    @GetMapping("/emp")
    public String goadd(Model model){

        List<Department> listall = departmentService.listall();

        model.addAttribute("dept_list",listall);


        return "add";


    }
    @PostMapping("/emp")
    public String insert_emp(Employee employee,
                             @RequestParam("department.id")Integer id ){

        employee.setdId(id);
        employeeService.insertemp(employee);

        return "redirect:/emps";

    }

    @PutMapping("/emp")
    public String update_emp(Employee employee,
                             @RequestParam("department.id") Integer id){
        employee.setdId(id);


        employeeService.updateemp(employee);


        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String del_emp(@PathVariable("id") Integer id){

        employeeService.deleteemp(id);


        return "redirect:/emps";
    }
}
