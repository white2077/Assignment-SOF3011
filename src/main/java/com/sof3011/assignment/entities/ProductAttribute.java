package com.sof3011.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;
import java.util.Set;

@Entity(name = "product_attributes")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class ProductAttribute extends CoreEntity {
    @Size(min = 5)
    @NotNull
    @Column(name = "attribute_name",columnDefinition = "nvarchar(255)")
    private String attributeName;
    @Column(name = "attribute_type")
    private Boolean attributeType;
    @NotNull
    @Size(min = 3)
    @Column(name = "slug",columnDefinition = "varchar(255)")
    private String slug;

    @ManyToOne
    private ProductAttribute attributeParent;

    @OneToMany(mappedBy = "attributeParent")
    private Set<ProductAttribute> childAttributes;
    @ManyToMany(mappedBy = "productVariantAttributes")
    Set<ProductVariant> productVariants;
    @ManyToMany(mappedBy = "productAttribute")
    private Set<Product> products;
}
