package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "admins")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends EntityCore{
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
    @Column(name = "admin_name",columnDefinition = "nvarchar(500)")
    private String adminName;
    @Size(max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(min = 5)
    @NotNull
    @Column(name = "email")
    private String email;
}
