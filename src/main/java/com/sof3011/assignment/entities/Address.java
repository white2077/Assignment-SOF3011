package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity(name = "addresses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends CoreEntity {
    @ManyToOne
    private Customer customer;
    @Size(min = 5)
    @NotNull
    @Column(name = "address")
    private String address;
}
