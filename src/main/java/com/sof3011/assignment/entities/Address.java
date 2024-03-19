package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5)
    @NotBlank(message = "Address is required")
    @Column(name = "address")
    private String address;
}
