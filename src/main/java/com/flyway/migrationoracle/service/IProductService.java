package com.flyway.migrationoracle.service;


import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.exception.ProductAlreadyExistsException;
import com.flyway.migrationoracle.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {

    /**
     *
     * @param id
     * @return
     */
    Product findProductById(Long id);


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
    void deleteProductById(Long id) throws ProductNotFoundException;

}
