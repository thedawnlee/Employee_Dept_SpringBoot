package com.dawnlee.crud01.Mapper;

import com.dawnlee.crud01.Bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface DepartmentMapper {


    @Select("select * from Department")
    public List<Department> Listall();

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into Department(departmentName) values(#{departmentName})")
    public void insertdept(Department department);


    @Delete("delete from Department where id = #{id}")
    public void deletedept(Integer id);

    @Select("select * from Department where id=#{id}")
    public Department getdeptName(Integer id);

}
