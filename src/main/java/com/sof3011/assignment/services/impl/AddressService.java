package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.entities.User;
import com.sof3011.assignment.repositories.IAddressRepository;
import com.sof3011.assignment.services.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {
    private final IAddressRepository addressRepository;
    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address insert(Address e) {
        if(addressRepository.findAll().isEmpty()){
            e.setDefaultAddress(true);
        }
        return addressRepository.save(e);
    }

    @Override
    public void update(Address e) {
        e.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
         addressRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void setDefaultAddress(User user, Long id) {
        List<Address> addresses = addressRepository.findAllByCustomer(user);
        addresses.forEach(address -> {
            address.setDefaultAddress(address.getId().equals(id));
            address.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        });
        addressRepository.saveAll(addresses);
    }

    @Override
    public void deleteByUser(User user, Long id) {
        addressRepository.deleteById(id);
        List<Address> addresses = addressRepository.findAllByCustomer(user);
        addresses.get(0).setDefaultAddress(true);
        addressRepository.saveAll(addresses);
    }
}
