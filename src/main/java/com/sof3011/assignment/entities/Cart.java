package com.sof3011.assignment.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.Expose;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "cart")
public class Cart extends CoreEntity{
    @ManyToOne
    private User customer;
    @ManyToOne
    private ProductVariant productVariant;
    private int quantity;
}
