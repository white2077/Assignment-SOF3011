package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAllByCustomer(User customer);
}
