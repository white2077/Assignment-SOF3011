package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "addresses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address extends CoreEntity {
    @ManyToOne
    private Customer customer;
    @Column(name = "address")
    private String address;
}
