package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product extends CoreEntity {
    @Size(min = 6)
    @NotNull
    @Column(name = "product_name",columnDefinition = "nvarchar(255)" ,nullable = false)
    private String productName;
    @Column(name = "status", nullable = false)
    private boolean status;
    @Column(name = "slug",columnDefinition = "nvarchar(255)" ,nullable = false)
    private String slug;
    @OneToMany(mappedBy = "product")
    private List<ProductVariant> productVariants;
    @Column(name = "description",columnDefinition = "nvarchar(MAX)")
    private String description;

    @ManyToMany
    private Set<ProductAttribute> productAttributes;
}
