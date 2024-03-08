package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.services.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {
    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address insert(Address e) {
        return null;
    }

    @Override
    public void update(Address e) {

    }

    @Override
    public void delete(Long id) {

    }
}
