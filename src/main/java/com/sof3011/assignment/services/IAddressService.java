package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.entities.User;

public interface IAddressService extends IServiceInterface<Address,Long> {
    void setDefaultAddress(User user, Long id);
    void deleteByUser(User user,Long id);
}
