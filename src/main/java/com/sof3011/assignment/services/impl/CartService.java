package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.User;
import com.sof3011.assignment.repositories.ICartRepository;
import com.sof3011.assignment.repositories.IProductVariantRepository;
import com.sof3011.assignment.services.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final IProductVariantRepository productVariantRepository;
    private final ICartRepository cartRepository;

    @Override
    public void addProductToCart(Long productId, int quantity, User user) {
        Cart cart = Cart.builder().productVariant(productVariantRepository.findById(productId).orElseThrow(()
                -> new NoSuchElementException("not found"))).quantity(quantity).customer(user).build();
        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public void updateProductQuantity(Long productId, int quantity, User user) {
        Cart cart = cartRepository.findById(productId).orElse(null);
        if (cart != null) {
            cart.setQuantity(quantity);
            cartRepository.save(cart);
        }
    }

    @Override
    public void clearCart() {
        cartRepository.deleteAll();
    }

    @Override
    public List<Cart> getCartByUser(User user) {
        return cartRepository.findCartByCustomer(user);
    }

    @Override
    public void insertAll(List<Cart> cart) {
        cartRepository.saveAll(cart);
    }

}
