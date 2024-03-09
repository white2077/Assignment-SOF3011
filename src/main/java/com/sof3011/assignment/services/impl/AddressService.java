package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.repositories.IAddressRepository;
import com.sof3011.assignment.services.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {
    private final IAddressRepository repository;

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address getById(Long aLong) {
        return null;
    }

    @Override
    public Address insert(Address e) {
        return repository.save(e);
    }

    @Override
    public void update(Long id, Address e) {

    }

    @Override
    public void delete(Long id) {

    }
}
