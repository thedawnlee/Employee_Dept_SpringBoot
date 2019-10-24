package com.dawnlee.crud01.Controller;

import com.dawnlee.crud01.Service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AdminUserService adminUserService;

//    @RequestMapping("/")
//    public String hello(){
//
//        return "index";
//    }
//
//    @RequestMapping("/login")
//    public String login_index(){
//
//        return "index";
//    }
    @PostMapping(value = "/user/login")
    public String login_admin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model,
                              HttpSession session){

        logger.info(username);

        logger.info(password);

        Boolean login = adminUserService.login(username, password);

        if(login){

            session.setAttribute("loginuser",username);
            return "redirect:/main.html";}
        else {
            return "redirect:/";
        }


    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginuser");
        return "redirect:/";
    }

}
