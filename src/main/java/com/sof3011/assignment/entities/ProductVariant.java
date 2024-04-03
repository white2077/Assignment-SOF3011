package com.sof3011.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity(name = "product_variants")
@AllArgsConstructor
@Builder
@Getter
@Setter
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
    @Size(min = 37,message = "please choose image")
    @Column(name = "image")
    private String image;
    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status;

    @ManyToMany
    private Set<ProductAttribute> productVariantAttributes;
    @ManyToOne
    private Product product;
}
