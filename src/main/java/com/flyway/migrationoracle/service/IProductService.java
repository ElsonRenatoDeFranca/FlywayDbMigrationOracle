package com.flyway.migrationoracle.service;


import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.exception.ProductAlreadyExistsException;
import com.flyway.migrationoracle.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {

    /**
     *
     * @param productId
     * @return
     */
    Product findProductById(Long productId);


    /**
     *
     * @param id
     * @return
     * @throws ProductNotFoundException
     */
    List<Product> findProductByCartId(Long id) throws ProductNotFoundException, CartNotFoundException;

    /**
     *
     * @return
     * @throws ProductNotFoundException
     */
    List<Product> findAll() throws ProductNotFoundException;


    /**
     *
     * @param product
     * @return
     */
    Product createProduct(Product product)  throws ProductAlreadyExistsException, ProductNotFoundException;

    /**
     *
     * @param id
     * @throws ProductNotFoundException
     */
    void removeProduct(Long id) throws ProductNotFoundException;

}
