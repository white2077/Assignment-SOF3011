package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order_items")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem extends CoreEntity {
    @ManyToOne
    private OrderDetail orderDetail;
    @ManyToOne
    private ProductVariant productVariant;
    @Min(value = 1)
    private long price;
    @Min(value = 1)
    private long quantity;
    @Column(name = "note",columnDefinition = "nvarchar(1000)")
    private String note;
}
