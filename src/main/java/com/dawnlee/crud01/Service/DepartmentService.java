package com.dawnlee.crud01.Service;


import com.dawnlee.crud01.Bean.Department;
import com.dawnlee.crud01.Bean.Employee;

import java.util.List;

public interface DepartmentService {

    public List<Department> listall();

    public void insertdept(Department department);

    public void deletedept(Integer id);


    public Department getdeptName(Integer id);

}
