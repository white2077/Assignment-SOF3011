package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Admin;
import com.sof3011.assignment.entities.Customer;

public interface ICustomerService extends IService<Customer,Long>{
    Customer login(Customer admin);
}