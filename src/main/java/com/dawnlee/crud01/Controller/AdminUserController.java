package com.dawnlee.crud01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Transactional(propagation = Propagation.SUPPORTS)
@Controller
public class AdminUserController {

    @RequestMapping("/find")
    public String findindex(){
        return "index";

    }
}
