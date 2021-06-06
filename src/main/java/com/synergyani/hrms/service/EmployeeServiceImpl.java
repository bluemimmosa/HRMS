/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.employee.Employee;
import com.synergyani.hrms.entity.employee.Teams;
import com.synergyani.hrms.repository.EmployeeRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */
@Transactional(rollbackFor = Exception.class) //implement roolback for ACID proeprty.
@Service
public class EmployeeServiceImpl implements EmployeeService, Serializable{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee emp) {
        
        return employeeRepository.save(emp);
    }

    @Override
    public Employee findEmployeeById(long eid) {
        Optional<Employee> empOpt = employeeRepository.findById(eid);
        if(empOpt.isPresent()){
            return empOpt.get();
        }
        return null;
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public ArrayList<Employee> findAll() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    @Override
    public Set<Teams> findTeamsByEmployee(long eid) {
        return employeeRepository.findAllTeamsByEmpId(eid);
    }
    
}
