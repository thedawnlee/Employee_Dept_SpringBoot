package com.dawnlee.crud01;

import com.dawnlee.crud01.Bean.AdminUser;
import com.dawnlee.crud01.Bean.Department;
import com.dawnlee.crud01.Bean.DeptAndEmp;
import com.dawnlee.crud01.Bean.Employee;
import com.dawnlee.crud01.Mapper.DepartmentMapper;
import com.dawnlee.crud01.Mapper.EmployeeMapper;
import com.dawnlee.crud01.Mapper.UserMapper;
import com.dawnlee.crud01.Service.AdminUserService;
import com.dawnlee.crud01.Service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Crud01ApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    AdminUserService adminUserService;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void contextLoads() throws SQLException {

        AdminUser adminUser = adminUserService.findbyId(1);

        AdminUser adminUser1 = new AdminUser();
        adminUser1.setEmail("1");
        adminUser1.setGender("mail");


        adminUserService.insert_Admin(adminUser1);

        System.out.println(adminUser);

    }

   @Test
   public void EmpTest(){

       Employee employee = employeeMapper.findbyId(1);

       System.out.println(employee);
   }


    @Test
    public void departmentest(){


        List<Department> listall = departmentMapper.Listall();


        System.out.println(listall);
    }

    @Test
    public void testEmp(){


        Employee employee = new Employee();

        employee.setEmail("11");
        employee.setGender(",male");
        employee.setLastName("dawnlee");
        employee.setdId(1);
        employeeMapper.insert_emp(employee);


    }


    @Test
    public void testempinsert(){


        List<Employee> employees = employeeMapper.findbyDept(1);


        System.out.println(employees);



    }

    @Test
    public void logintest(){

        Boolean admin = adminUserService.login("admin", "123456");

        System.out.println(admin);

    }
    @Test
    public void testqury(){


        List<DeptAndEmp> deptAndEmps = new ArrayList<>();
        List<Employee> listall = employeeService.listall();
        for(int i = 0;i<listall.size();i++){

            DeptAndEmp deptAndEmp = new DeptAndEmp();
            Employee employee = listall.get(i);
            Department department = departmentMapper.getdeptName(employee.getdId());

            deptAndEmp.setEmployee(employee);
            deptAndEmp.setDepartment(department);
            String departmentName = deptAndEmp.getDepartment().getDepartmentName();

            logger.info(departmentName);
            logger.info(deptAndEmp.toString());
            deptAndEmps.add(deptAndEmp);

        }
        logger.info(deptAndEmps.toString());


    }


    @Test
    public void deptnameTest(){


        Employee employee = new Employee();


        employee.setLastName("lst");
        employee.setdId(1);
        employee.setGender("male");
        employee.setId(1);
        employeeService.updateemp(employee);

    }
}