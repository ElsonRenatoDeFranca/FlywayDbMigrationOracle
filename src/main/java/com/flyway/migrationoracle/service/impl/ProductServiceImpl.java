package com.flyway.migrationoracle.service.impl;

import com.flyway.migrationoracle.constants.CartAppConstants;
import com.flyway.migrationoracle.entity.Cart;
import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.exception.ProductAlreadyExistsException;
import com.flyway.migrationoracle.exception.ProductNotFoundException;
import com.flyway.migrationoracle.repository.ProductRepository;
import com.flyway.migrationoracle.service.ICartService;
import com.flyway.migrationoracle.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ICartService cartService;



    @Override
    public Product findProductById(Long id) {
        return productRepository.findByid(id);
    }

    @Override
    public List<Product> findProductByCartId(Long id) throws ProductNotFoundException, CartNotFoundException {
        Cart cart = cartService.findCartById(id);

        if(cart != null){
            return cart.getProducts();
        }else{
            throw new ProductNotFoundException(CartAppConstants.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
        }

    }

    @Override
    @Cacheable("products")
    public List<Product> findAll() throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product createProduct(Product product) throws ProductAlreadyExistsException, ProductNotFoundException {
        Product searchedProduct = this.findProductById(product.getId());

        if(searchedProduct != null){
            throw new ProductNotFoundException(CartAppConstants.PRODUCT_ALREADY_EXISTS_ERROR_MESSAGE);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {
        Product searchedProduct = this.findProductById(id);

        if(searchedProduct == null){
            throw new ProductNotFoundException(CartAppConstants.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
        }
        //productRepository.delete(searchedProduct);
        productRepository.deleteById(id);

    }

}
