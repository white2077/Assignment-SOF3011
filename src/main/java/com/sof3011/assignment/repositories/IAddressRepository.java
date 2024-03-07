package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Long> {
}
