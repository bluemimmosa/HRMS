/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.employee.OfficeDetails;

/**
 *
 * @author Dell
 */
public interface OfficeDetail {
    public OfficeDetails findOfficeDetails(long empID);
}
