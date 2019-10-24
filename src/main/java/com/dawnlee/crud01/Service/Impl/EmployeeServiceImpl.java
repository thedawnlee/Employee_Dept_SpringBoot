package com.dawnlee.crud01.Service.Impl;

import com.dawnlee.crud01.Bean.Employee;
import com.dawnlee.crud01.Mapper.EmployeeMapper;
import com.dawnlee.crud01.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    @Cacheable(value = {"emp"})
    @Override
    public Employee findbyId(Integer id) {
        Employee employee1 = employeeMapper.findbyId(id);

        return employee1;
    }
    @CachePut(value = {"emp"})
    @Override
    public void insertemp(Employee employee) {

        employeeMapper.insert_emp(employee);

    }
    @CachePut(value = {"emp"},key = "#value.id")
    @Override
    public void updateemp(Employee employee) {

        employeeMapper.update(employee);

    }
    @CacheEvict(value = {"emp"},beforeInvocation = true)
    @Override
    public void deleteemp(Integer id) {

        employeeMapper.delete(id);

    }
    @Cacheable(value = {"emp"})
    @Override
    public List<Employee> listall() {
        return employeeMapper.listall();
    }

    @Override
    @Cacheable(value = {"emp"})
    public List<Employee> findbyDept(Integer id) {
        return employeeMapper.findbyDept(id);
    }
}
