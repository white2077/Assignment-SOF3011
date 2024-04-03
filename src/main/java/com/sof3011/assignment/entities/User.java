package com.sof3011.assignment.entities;

import com.sof3011.assignment.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity(name = "customers")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class User extends CoreEntity {
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
    @NotBlank(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "customer")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "customer")
    private List<Cart> cartItems;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
