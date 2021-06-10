/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.User;
import com.synergyani.hrms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository ur;
    
    @Override
    public User addUser(User u) {
        return ur.save(u);
    }
    
}
