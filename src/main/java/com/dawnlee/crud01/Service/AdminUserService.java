package com.dawnlee.crud01.Service;

import com.dawnlee.crud01.Bean.AdminUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminUserService {

    public AdminUser findbyId(Integer id);
    public int insert_Admin(AdminUser adminUser);

    public Boolean login(String username,String password);

}
