package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "cart")
public class Cart extends CoreEntity{
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private ProductVariant productVariant;
    @Column(name = "quantity")
    @NotBlank(message = "quantity not blank or null")
    private int quantity;
}
