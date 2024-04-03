package com.sof3011.assignment.entities;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

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

    @Size(min = 37,message = "please choose thumbnail")
    @Column(name = "thumbnail")
    private String thumbnail;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductVariant> productVariants;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<ProductAttribute> productAttribute;

    @Transient
    private Map<String,Long> minMaxPrices;

    public Map<String, Long> getMinMaxPrices() {
        Map<String, Long> minMaxValues = new HashMap<>();
        Optional<Long> min = productVariants.stream()
                .map(ProductVariant::getPrice)
                .min(Long::compareTo);
        Optional<Long> max = productVariants.stream()
                .map(ProductVariant::getPrice)
                .max(Long::compareTo);
        min.ifPresent(value -> minMaxValues.put("min", value));
        max.ifPresent(value -> minMaxValues.put("max", value));
        return minMaxValues;
    }
}
