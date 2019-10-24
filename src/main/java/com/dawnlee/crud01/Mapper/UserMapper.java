package com.dawnlee.crud01.Mapper;

import com.dawnlee.crud01.Bean.AdminUser;
import com.dawnlee.crud01.Bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface UserMapper {

    @Select("select * from AdminUser where username=#{username} and password=#{password}")
    public List<AdminUser> login(String username, String password);


@Select("select * from AdminUser where id=#{id}")
public AdminUser findbyId(Integer id);

@Options(useGeneratedKeys = true,keyProperty = "id")
@Insert("insert into AdminUser(username,password,lastName,email,gender,qx) values(#{username},#{password},#{lastName},#{email},#{gender},#{qx})")
public void insert_admin(AdminUser adminUser);





}
