package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "product_variants")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductVariant extends CoreEntity {
    @Size(min = 6)
    @NotNull
    @Column(name = "variant_name", columnDefinition = "nvarchar(255)")
    private String variantName;
    @Column(name = "price")
    @Min(value = 1)
    private long price;
    @Column(name = "quantity")
    @Min(value = 1)
    private int quantity;
    @NotBlank
    @Column(name = "image")
    private String image;
    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status;

    @ManyToOne
    private Product product;
}
