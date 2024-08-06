package com.ems.rehearse2.service;

import com.ems.rehearse2.domain.Product;
import com.ems.rehearse2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 3. Third
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products) { return productRepository.saveAll(products); }

    public List<Product> findAllProducts() { return productRepository.findAll(); }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findProductByName(String name) {
        return Optional.ofNullable(productRepository.findByName(name));
    }

    public void deleteProductById(Long id) {
        boolean existed = productRepository.existsById(id);
        if (!existed) {
            throw new ProductNotFoundException("Not found product id: " + id);
        }
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        Product foundProduct = productRepository.findById(product.getId()).orElseThrow(
                () -> new ProductNotFoundException("Not found product id: " + product.getId())
        );
        foundProduct.setName(product.getName());
        foundProduct.setQuantity(product.getQuantity());
        foundProduct.setPrice(product.getPrice());
        return productRepository.save(foundProduct);
    }

    // Custom exception class for product not found
    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

}