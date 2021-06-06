/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.repository;

import com.synergyani.hrms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dell
 */
public interface UserRepository extends JpaRepository<User, Long>{    
    public User findByUserName(String userName);
}
