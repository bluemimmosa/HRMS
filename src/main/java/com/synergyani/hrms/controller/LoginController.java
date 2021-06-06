/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.controller;

import com.synergyani.hrms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public ModelAndView login() {
       ModelAndView mav = new ModelAndView("login");
       //mav.addObject("newUser", new User());
       return mav;
    }
    
    @GetMapping("/")
    public String loginSuccess(){
        return "dashboard";
    }
    
    
    
    
}
