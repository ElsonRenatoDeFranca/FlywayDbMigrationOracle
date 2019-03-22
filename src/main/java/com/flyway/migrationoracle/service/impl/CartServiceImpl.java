package com.flyway.migrationoracle.service.impl;

import com.flyway.migrationoracle.constants.CartAppConstants;
import com.flyway.migrationoracle.entity.Cart;
import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.repository.CartRepository;
import com.flyway.migrationoracle.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        List<Cart> carts = new ArrayList<>();
        cartRepository.findAll().forEach(carts::add);
        return carts;
    }

    @Override
    public Cart findCartById(Long cartId) throws CartNotFoundException {
        return Optional.of(cartRepository.findByid(cartId)).orElseThrow(() -> new CartNotFoundException(CartAppConstants.CATEGORY_NOT_FOUND_ERROR_MESSAGE));
    }


    @Override
    public Cart addProductIntoCart(Long cartId, Product product) throws CartNotFoundException{
        Cart cart = this.findCartById(cartId);
        cart.getProducts().add(product);
        cartRepository.save(cart);
        return cart;
    }


    @Override
    public Cart createCart() {
        Cart newCart = new Cart();
        return cartRepository.save(newCart);
    }

}