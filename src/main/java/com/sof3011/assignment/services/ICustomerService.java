package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Customer;

public interface ICustomerService extends IServiceInterface<Customer,Long> {
    Customer login(Customer admin);
}
