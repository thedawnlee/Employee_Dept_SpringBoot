package com.dawnlee.crud01.Service.Impl;

import com.dawnlee.crud01.Bean.AdminUser;
import com.dawnlee.crud01.Mapper.UserMapper;
import com.dawnlee.crud01.Service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {


    @Autowired
    UserMapper userMapper;
    @Override
    public int insert_Admin(AdminUser adminUser) {
        userMapper.insert_admin(adminUser);
        return 1;
    }

    @Override
    public Boolean login(String username, String password) {
        List<AdminUser> login = userMapper.login(username, password);

        if(login.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public AdminUser findbyId(Integer id) {

        return userMapper.findbyId(id);

    }
}
