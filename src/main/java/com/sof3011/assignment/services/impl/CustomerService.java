package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Customer;
import com.sof3011.assignment.exception.EntityNotFoundGeneralException;
import com.sof3011.assignment.repositories.ICustomerRepository;
import com.sof3011.assignment.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer getById(Long aLong) {
        Optional<Customer> customer = iCustomerRepository.findById(aLong);
        return customer.orElseThrow();
    }

    @Override
    public Customer insert(Customer e) {
        return iCustomerRepository.save(e);
    }

    @Override
    public void update(Long id, Customer e) {
        Optional<Customer> c = iCustomerRepository.findById(id);
        if (c.isPresent()) {
            Customer customer = c.get();
            if (e.getAddresses() != null) {
                customer.setAddresses(e.getAddresses());
            }
            if (e.getCustomerName() != null) {
                customer.setCustomerName(e.getCustomerName());
            }
            if (e.getEmail() != null) {
                customer.setEmail(e.getEmail());
            }
            if (e.getPhoneNumber() != null) {
                customer.setPhoneNumber(e.getPhoneNumber());
            }
            if (e.getUsername() != null) {
                customer.setUsername(e.getUsername());
            }
            if (e.getPassword() != null) {
                customer.setPassword(e.getPassword());
            }
            iCustomerRepository.save(customer);
        }
        else throw new EntityNotFoundGeneralException("entity " + e.getClass() + " not found");
    }

    @Override
    public void delete(Long id) {
        if (iCustomerRepository.existsById(id)) {
            iCustomerRepository.deleteById(id);
        }
        else throw new EntityNotFoundGeneralException("entity customer not found");
    }

    @Override
    public Customer login(Customer admin) {
        return null;
    }
}
