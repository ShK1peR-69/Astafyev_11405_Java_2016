package com.springapp.mvc.services;

import com.springapp.mvc.common.Address;
import com.springapp.mvc.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void addNewAddress(Address address) {
        addressRepository.addNewAddress(address);
    }

    @Transactional
    public Address getAddressByUser(Long id) {
        return addressRepository.getAddressByUser(id);
    }
}