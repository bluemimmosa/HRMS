/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.employee.Education;
import com.synergyani.hrms.repository.EducationRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dell
 */
public class EducationServiceImpl implements EducationService {
    
    @Autowired
    EducationRepository educationRepository;
    
    @Override
    public List<Education> findEducationDetails(long empId) {
        return new ArrayList<>();
    }

    @Override
    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }
    
}
