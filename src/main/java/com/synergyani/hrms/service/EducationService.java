/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.employee.Education;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface EducationService {
    public List<Education> findEducationDetails(long empId);
    public Education saveEducation(Education education);
}
