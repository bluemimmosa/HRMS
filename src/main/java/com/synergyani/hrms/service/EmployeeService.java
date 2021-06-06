/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.employee.Employee;
import com.synergyani.hrms.entity.employee.Teams;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Dell
 */
public interface EmployeeService {
    public Employee addEmployee(Employee emp);
    public Employee findEmployeeById(long eid);
    public Employee findEmployeeByName(String name);
    public ArrayList<Employee> findAll();
    public Set<Teams> findTeamsByEmployee(long eid);
}
