package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.User;

import java.util.List;

public interface ICartService {
    public void addProductToCart(Long productId, int quantity, User user);
    public void removeProductFromCart(Long cartId);
    public void updateProductQuantity(Long productId, int quantity,User user);
    public void clearCart();
    public List<Cart> getCartByUser(User user);
    public void insertAll(List<Cart> cart);
}
