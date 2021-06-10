/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.controller;

import com.synergyani.hrms.entity.employee.Address;
import com.synergyani.hrms.entity.employee.AddressVO;
import com.synergyani.hrms.entity.employee.Contact;
import com.synergyani.hrms.entity.employee.Education;
import com.synergyani.hrms.entity.employee.EducationVO;
import com.synergyani.hrms.entity.employee.Employee;
import com.synergyani.hrms.entity.employee.FamilyDetail;
import com.synergyani.hrms.entity.employee.Health;
import com.synergyani.hrms.entity.employee.IdentityDocuments;
import com.synergyani.hrms.entity.employee.OfficeDetails;
import com.synergyani.hrms.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService es;
    
    Employee emp;
    List<Education> ed = new ArrayList<>();
    
    //Serve the new employee page.
    @GetMapping("/newEmployee-personalinfo")
    public ModelAndView showNewEmployeeForm(){
        ModelAndView mav = new ModelAndView("newEmployee-personalinfo");
        mav.addObject("newEmployee", new Employee());
        return mav;
    }
    
    //Step 1: Create meployee with emp personal data and serve contact page.
    @PostMapping("/newEmployee")
    public ModelAndView processNewEmployee(@ModelAttribute("newEmployee") Employee employee){
        emp = employee;
        System.out.println(emp.toString());
        ModelAndView mav = new ModelAndView("newEmployee-Contact");
        mav.addObject("empcontact", new Contact());
        return mav;
    }
    
    //Step 2: Add contacts to emp data and serve Address page.
    @PostMapping("/empcontact")
    public ModelAndView processEmpContact(@ModelAttribute("empcontact") Contact contact){
        List<Contact> cList = new ArrayList<>();
        cList.add(contact);
        emp.setContactdetails(cList);
        ModelAndView mav = new ModelAndView("newEmployee-Address");
        
        
        mav.addObject("newAddress", new AddressVO());
        
        return mav;
    }
    
    //Step 3: Add address to emp data and serve FamDetail Page.
    @PostMapping("/newAddress")
    public ModelAndView processEmpAddress(@ModelAttribute("newAddress") AddressVO address){
//        System.out.println(address.getPermaAddress().toString());
//        System.out.println(address.getTempAddress().toString());
        emp.setPermaAddress(address.getPermaAddress());
        emp.setTempAddress(address.getTempAddress());
        
        ModelAndView mav = new ModelAndView("newEmployee-FamilyDetail");
        mav.addObject("newFamilyDetail", new FamilyDetail());
        return mav;
    }
    
    @PostMapping("/newFamilyDetail")
    public ModelAndView processFamilyDetail(@ModelAttribute("newFamilyDetail") FamilyDetail fam){
        emp.setFamdetails(fam);
        ModelAndView mav = new ModelAndView("newEmployee-Health");
        mav.addObject("newHealth", new Health());
        return mav;
    }
    
    @PostMapping("/newHealth")
    public ModelAndView processHealth(@ModelAttribute("newHealth") Health health){
        emp.setHealthdetails(health);
        ModelAndView mav = new ModelAndView("newEmployee-IdentityDocuments");
        mav.addObject("newIdentityDocuments", new IdentityDocuments());
        return mav;
    }
    
    @PostMapping("/newIdentityDocuments")
    public ModelAndView processIdentityDocuments(@ModelAttribute("newIdentityDocuments") IdentityDocuments identityDocuments){
        List<IdentityDocuments> idList = new ArrayList<>();
        idList.add(identityDocuments);
        emp.setIdDocs(idList);
        //System.out.println(emp.toString());
        ModelAndView mav = new ModelAndView("newEmployee-Education");
        mav.addObject("newEducation", new EducationVO());
        return mav;
    }
    
    @PostMapping("/newEducation")
    public ModelAndView processEducation(@ModelAttribute("newEducation") EducationVO education){
        ed.add(education.getEducation());
        
        if(education.isAddAnotherEducation()){
            ModelAndView mav = new ModelAndView("newEmployee-Education");
            mav.addObject("newEducation", new EducationVO());
            return mav;
        }
        
        emp.setEducationdetails(ed);
        
        ModelAndView mav = new ModelAndView("newEmployee-OfficeDetail");
        mav.addObject("newOfficeDetail", new OfficeDetails());
        return mav;
    }
    
    @PostMapping("/newOfficeDetail")
    public ModelAndView processOfficeDetails(@ModelAttribute("newOfficeDetail") OfficeDetails officeDetail){
        emp.setOd(officeDetail);
        System.out.println(emp.toString());
        es.addEmployee(emp);
        ModelAndView mav = new ModelAndView("employees");
        mav.addObject("empList", es.findAll());
        return mav;
    }
    
    
//    @GetMapping("/newEmployee-Contact")
//    public ModelAndView showNewEmployeeContactForm(){
//        ModelAndView mav = new ModelAndView("newEmployee-Contact");
//        
//        return mav;
//    }
    //For listing all he employees added so far.
    @GetMapping("/employees")
    public ModelAndView listAllEmployee(){
        ModelAndView mav = new ModelAndView("employees");
        mav.addObject("empList", es.findAll());
        System.out.println("Hello this is test............................................................................");
        for(Employee e: es.findAll()){
            List<Education> ed = e.getEducationdetails();
            for(Education edu : ed){
                System.out.println(edu);
            }
        }
        return mav;
    }
    

    
}
