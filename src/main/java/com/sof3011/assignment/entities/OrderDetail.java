package com.sof3011.assignment.entities;

import com.sof3011.assignment.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity(name = "order_details")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class OrderDetail extends CoreEntity {
    @ManyToOne
    private Customer customer;

    @NotNull
    @Size(min = 5 , message = "Address must be at least 5 characters")
    @Column(name = "address",columnDefinition = "nvarchar(100)")
    private String address;

    @NotNull
    @Size(min = 5, message = "City or Province must be at least 5 characters")
    @Column(name = "city_or_province",columnDefinition = "nvarchar(100)")
    private String cityOrProvince;

    @NotNull
    @Size(min = 5, message = "District must be at least 5 characters")
    @Column(name = "district",columnDefinition = "nvarchar(100)")
    private String district;

    @NotBlank(message = "Phone number is required")
    @Size(max = 10, message = "Phone number must be at most 10 characters")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "customer_name",columnDefinition = "nvarchar(500)")
    @NotNull
    @Size(min = 5, message = "Customer name must be at least 5 characters")
    private String customerName;

    @Column(name = "total")
    private Long total;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "orderDetail")
    private List<OrderItem> orderItems;
}
