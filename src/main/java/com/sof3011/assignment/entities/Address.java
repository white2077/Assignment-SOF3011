package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity(name = "addresses")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends CoreEntity {
    @ManyToOne
    private User customer;

    @Size(min = 5)
    @NotNull(message = "Address is required")
    @Column(name = "address")
    private String address;

    @NotNull
    @Size(min = 5, message = "City or Province must be at least 5 characters")
    @Column(name = "city_or_province",columnDefinition = "nvarchar(100)")
    private String cityOrProvince;

    @NotNull
    @Size(min = 5, message = "District must be at least 5 characters")
    @Column(name = "district",columnDefinition = "nvarchar(100)")
    private String district;

    private boolean defaultAddress;
}
