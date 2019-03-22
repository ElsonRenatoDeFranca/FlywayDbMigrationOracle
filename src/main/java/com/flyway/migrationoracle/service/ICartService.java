package com.flyway.migrationoracle.service;


import com.flyway.migrationoracle.entity.Cart;
import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;

import java.util.List;

public interface ICartService {


    /**
     *
     * @return
     * @throws CartNotFoundException
     */
    List<Cart> findAll();

    /**
     *
     * @param cartId
     * @return
     * @throws CartNotFoundException
     */
    Cart findCartById(Long cartId)  throws CartNotFoundException;


    /***
     *
     * @param cartId
     * @param product
     * @return
     * @throws CartNotFoundException
     */
    Cart addProductIntoCart(Long cartId, Product product) throws CartNotFoundException;

    /**
     *
     * @return
     */
    Cart createCart();


}
