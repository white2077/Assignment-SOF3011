package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "customers")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Customer extends EntityCore {
    @NotNull
    @Size(min = 5)
    @Column(name = "username")
    private String username;
    @Size(min = 5)
    @NotNull
    @Column(name = "password")
    private String password;
    @Size(min = 5)
    @NotNull
    @Column(name = "customer_name",columnDefinition = "nvarchar(500)")
    private String customerName;
    @Size(max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(min = 5)
    @NotNull
    @Column(name = "email")
    private String email;
    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "customer")
    private List<OrderDetail> orderDetails;

    @ManyToMany
    @JoinTable(name = "cart")
    private List<ProductVariant> cartItems;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
