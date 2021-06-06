/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.service;

import com.synergyani.hrms.entity.employee.Address;
import com.synergyani.hrms.repository.AddressRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address add) {
        return addressRepository.save(add);
    }

    @Override
    public Address findAddressByAid(long aid) {
        Optional<Address> data = addressRepository.findById(aid);
        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    @Override
    public List<Address> findAllByDistrict(String district) {
        return addressRepository.findAllByDistrict(district);
    }

    @Override
    public List<Address> findAllByTole(String tole) {
        return addressRepository.findAllByTole(tole);
    }

    @Override
    public List<Address> findAllByMunicipality(String mun) {
        return addressRepository.findAllByMunicipality(mun);
    }

    @Override
    public List<Address> findAllByState(String state) {
        return addressRepository.findAllByState(state);
    }
}
