package com.sof3011.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductVariant {
    private String variantName;
    private double price;
    private int quantity;
    private String image;
    private boolean status;
    private long id;
    private Timestamp createdDate;
}
