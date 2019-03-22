package com.flyway.migrationoracle.controller;


import com.flyway.migrationoracle.entity.Cart;
import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartAlreadyExistsException;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.exception.ProductAlreadyExistsException;
import com.flyway.migrationoracle.exception.ProductNotFoundException;
import com.flyway.migrationoracle.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CartController {

    @Autowired
    private ICartService cartService;

    @RequestMapping(method=RequestMethod.GET, value = "/cart/findAll")
    public List<Cart> findAll() throws CartNotFoundException, ProductNotFoundException {
        return cartService.findAll();
    }


    @RequestMapping(method=RequestMethod.GET,value="/cart/{cartId}")
    public ResponseEntity<Cart> findCartByCartId(@PathVariable Long cartId){
        try {
            Cart cart = cartService.findCartById(cartId);
            return new ResponseEntity<>(cart, HttpStatus.OK);

        }catch(CartNotFoundException catEx){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.POST,value="/cart/{cartId}/products",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> addProductIntoCart(@PathVariable Long cartId, @RequestBody Product product){
        try {
            Cart cartSaved = this.cartService.addProductIntoCart(cartId, product);
            return new ResponseEntity<>(cartSaved, HttpStatus.OK);
        }catch(CartNotFoundException ex){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(method=RequestMethod.POST, value="/carts")
    public ResponseEntity<Cart> createCart() {
        Cart persistedCart = cartService.createCart();

        if(null != persistedCart.getId()){
            return new ResponseEntity<> (persistedCart,HttpStatus.OK);
        }else{
            return new ResponseEntity<> (persistedCart,HttpStatus.BAD_REQUEST);
        }


    }


}
