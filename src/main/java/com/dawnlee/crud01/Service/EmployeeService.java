package com.dawnlee.crud01.Service;

import com.dawnlee.crud01.Bean.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee findbyId(Integer id);

    public void insertemp(Employee employee);

    public void updateemp(Employee employee);

    public void deleteemp(Integer id);

    public List<Employee> listall();

    public List<Employee> findbyDept(Integer id);
}
