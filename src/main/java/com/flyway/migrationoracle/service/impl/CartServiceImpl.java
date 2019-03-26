package com.flyway.migrationoracle.service.impl;

import com.flyway.migrationoracle.constants.CartAppConstants;
import com.flyway.migrationoracle.entity.Cart;
import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.exception.ProductNotFoundException;
import com.flyway.migrationoracle.repository.CartRepository;
import com.flyway.migrationoracle.repository.ProductRepository;
import com.flyway.migrationoracle.service.ICartService;
import com.flyway.migrationoracle.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductService productService;

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

    @Override
    public Cart removeProductFromCart(Long cartId, Product product) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = this.findCartById(cartId);
        cart.getProducts().removeIf(p -> p.equals(product));
        cartRepository.delete(cart);
        return cart;
    }

}