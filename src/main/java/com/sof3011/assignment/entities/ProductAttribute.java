package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity(name = "product_attributes")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductAttribute extends CoreEntity {
    @Size(min = 5)
    @NotNull
    private String attributeName;

    @ManyToOne
    private ProductAttribute attributeParent;
    @OneToMany(mappedBy = "attributeParent")
    private List<ProductAttribute> productAttributes;
    @NotNull
    @Size(min = 3)
    @Column(name = "slug",columnDefinition = "nvarchar(255)")
    private String slug;
    @ManyToMany(mappedBy = "productAttributes")
    Set<Product> products;
}
