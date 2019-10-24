package com.dawnlee.crud01.Service.Impl;

import com.dawnlee.crud01.Bean.Department;
import com.dawnlee.crud01.Bean.Employee;
import com.dawnlee.crud01.Mapper.DepartmentMapper;
import com.dawnlee.crud01.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> listall() {
        return departmentMapper.Listall();
    }
    @CachePut
    @Override
    public void insertdept(Department department) {
        departmentMapper.insertdept(department);

    }

    @CacheEvict
    @Override
    public void deletedept(Integer id) {
    departmentMapper.deletedept(id);
    }

    @Cacheable
    @Override
    public Department getdeptName(Integer id) {
        Department department = departmentMapper.getdeptName(id);
        return department;
    }
}
