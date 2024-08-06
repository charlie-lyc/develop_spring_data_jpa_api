package com.ems.rehearse2.controller;

import com.ems.rehearse2.domain.Product;
import com.ems.rehearse2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 4. Fourth
 */
@RestController
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String hello() {
        return "This is th JPA CRUD API.";
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> foundProduct = productService.findProductById(id);
        return foundProduct.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/product")
    public  ResponseEntity<Product> getProductByName(@RequestParam(required = true) String name) {
        Optional<Product> foundProduct = productService.findProductByName(name);
        return foundProduct.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProductService.ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product")
    public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
        try {
            Product modifiedProduct = productService.updateProduct(product);
            return new ResponseEntity<>(modifiedProduct, HttpStatus.OK);
        } catch (ProductService.ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> addedProducts = productService.saveAllProducts(products);
        return new ResponseEntity<>(addedProducts, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

}
