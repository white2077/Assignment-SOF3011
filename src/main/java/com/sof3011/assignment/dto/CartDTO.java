package com.sof3011.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public abstract class CartDTO {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
   public static class CartRequest extends CartDTO {
      private Long productVariantId;
      private int quantity;
   }
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
   public static class CartCookie extends CartDTO {
        private ProductVariant productVariant;
        private int quantity;
   }
}
