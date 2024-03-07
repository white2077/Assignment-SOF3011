package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "order_items")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends CoreEntity {
    @NotNull
    @ManyToOne
    private OrderDetail orderDetail;
    @NotNull
    @ManyToOne
    private ProductVariant productVariant;
    private long price;
    @Column(name = "note",columnDefinition = "nvarchar(1000)")
    private String note;
}
