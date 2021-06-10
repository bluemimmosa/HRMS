/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.entity.employee;

import com.synergyani.hrms.entity.Role;
import com.synergyani.hrms.entity.User;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Dell
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long empId;
    
    String name;
    Date dob;
    char gender;
    String maritial;
    String nationality;
    String photoFile;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    User user;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tempaddress_fk")
    Address tempAddress;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "permaaddress_fk")
    Address permaAddress;
    
    
    //make correction to one to one as you have join date and perma date field.
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "od_fk")
    OfficeDetails od;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empteams",
               joinColumns = @JoinColumn(name="empid"),
               inverseJoinColumns = @JoinColumn(name = "tid")
              )
    Set<Teams> empteams;
     
    //onetomany in hibernate has problem that you cannot assign same role to multiple user. so make it manytomany.
    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="emprole_fk", referencedColumnName="empId")
    List<Role> emprole; //Use set where you need guarantee to have no duplicate values.
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="famdetails_fk")
    FamilyDetail famdetails;
    
    @OneToMany(targetEntity = Contact.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="contactdetails_fk", referencedColumnName="empId")
    List<Contact> contactdetails;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="healthdetails_fk")
    Health healthdetails;
    
    @OneToMany(targetEntity = IdentityDocuments.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="identitydocuments_fk", referencedColumnName="empId")
    List<IdentityDocuments> idDocs;
    
    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="education_fk", referencedColumnName="empId")
    List<Education> educationdetails;
    
    
}
