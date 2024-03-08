package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Customer;
import com.sof3011.assignment.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer insert(Customer e) {
        return null;
    }

    @Override
    public void update(Customer e) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Customer login(Customer admin) {
        return null;
    }
}
