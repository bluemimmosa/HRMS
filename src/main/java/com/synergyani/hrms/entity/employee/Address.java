/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.entity.employee;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

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
@Table(name="address")
public class Address{
    @Id
    @Column(name="aid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long aid;
    
    String state;
    String district;
    String municipality;
    int wardNo;
    String tole;
    @Column(nullable = true)
    int houseNo;

    
}
