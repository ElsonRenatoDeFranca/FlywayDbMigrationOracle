package com.flyway.migrationoracle.controller;

import com.flyway.migrationoracle.entity.Product;
import com.flyway.migrationoracle.exception.CartNotFoundException;
import com.flyway.migrationoracle.exception.ProductAlreadyExistsException;
import com.flyway.migrationoracle.exception.ProductNotFoundException;
import com.flyway.migrationoracle.service.IProductService;
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

/**
 * Created by e068635 on 3/7/2019.
 */

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;


    @RequestMapping(method= RequestMethod.POST, value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws ProductAlreadyExistsException, ProductNotFoundException {
        Product persistedCategory = productService.createProduct(product);

        if(null != persistedCategory){
            return new ResponseEntity<> (persistedCategory, HttpStatus.OK);
        }else{
            return new ResponseEntity<> (persistedCategory,HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> removeProduct(@PathVariable(name="id") Long id) throws ProductNotFoundException {
        try {
            productService.removeProduct(id);
            return new ResponseEntity<> (HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method=RequestMethod.GET,value="/products")
    public ResponseEntity<List<Product>> findAll(){

        try {
            List<Product> products = productService.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);

        }catch(ProductNotFoundException prodEx){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.GET,value="/product/cart/{id}")
    public ResponseEntity<List<Product>> findProductByCartId(@PathVariable Long id){

        try {
            List<Product> products = productService.findProductByCartId(id);
            return new ResponseEntity<>(products, HttpStatus.OK);

        }catch(ProductNotFoundException | CartNotFoundException exception){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

}
