package com.dawnlee.crud01.Mapper;

import com.dawnlee.crud01.Bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface EmployeeMapper {


    @Select("select * from Employee where id=#{id}")
    public Employee findbyId(Integer id);


    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into Employee(lastName,gender,email,dId,birth) values(#{lastName},#{gender},#{email},#{dId},#{birth})")
    public void insert_emp(Employee employee);


    @Delete("delete from Employee where id=#{id}")
    public void delete(Integer id);

    @Update("UPDATE Employee SET lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId},birth=#{birth} WHERE id=#{id}")
//
    public void update(Employee employee);

    @Select("select * from Employee where dId=#{id}")
    public List<Employee> findbyDept(Integer id);

    @Select("select * from Employee")
    public List<Employee> listall();





}
