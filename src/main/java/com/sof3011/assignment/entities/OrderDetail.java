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
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "order_details")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderDetail extends CoreEntity {
    @ManyToOne
    private Customer customer;
    @Column(name = "address",columnDefinition = "nvarchar(1000)")
    private String address;
    @Size(max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "customer_name",columnDefinition = "nvarchar(500)")
    @NotNull
    @Size(max = 10)
    private String customerName;
    @Column(name = "total")
    private Long total;
    @Column(name = "status")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "orderDetail")
    private List<OrderItem> orderItems;
}
