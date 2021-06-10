/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.controller;

import com.synergyani.hrms.entity.User;
import com.synergyani.hrms.entity.UserVO;
import com.synergyani.hrms.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class UserController {
    @Autowired
     UserService usr;
    
    @GetMapping("/users")
    public ModelAndView servenewUserPage(){
        ModelAndView mav = new ModelAndView("newUser");
        mav.addObject("newUser",new UserVO());
        return mav;
    }
    
    @PostMapping("/newUser")
    public ModelAndView addUser(@ModelAttribute("newUser") UserVO user){
        user.getUser().setEnabled(true);
        user.getUser().setRole(user.getRole());
        System.out.println("\n\n\n\n\n\nThe role is: ");
        System.out.println(user.getUser());
        System.out.println("\n\n\n\n\n\n");
        usr.addUser(user.getUser());
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
        
    }
}
