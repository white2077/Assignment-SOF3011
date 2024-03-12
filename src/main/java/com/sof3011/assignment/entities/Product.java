package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
    @Size(min = 6,message = "Product name must more than 6 character")
    @NotNull(message = "Product name is not null")
    @Column(name = "product_name",columnDefinition = "nvarchar(255)" ,nullable = false)
    private String productName;
    @NotNull
    @Column(name = "status")
    private boolean status;
    @NotNull(message = "Slug is not null")
    @Size(min = 6,message = "slug must more than 6 character")
    @Column(name = "slug",columnDefinition = "nvarchar(255)" ,nullable = false)
    private String slug;
    @NotBlank(message = "Descriptions is not blank")
    @Column(name = "description",columnDefinition = "Text")
    private String description;
    @NotBlank(message = "Thumbnail is not null or blank")
    @Column(name = "thumbnail")
    private String thumbnail;

    @OneToMany(mappedBy = "product")
    private List<ProductVariant> productVariants;

    @ManyToMany
    private Set<ProductAttribute> productAttribute;
}
