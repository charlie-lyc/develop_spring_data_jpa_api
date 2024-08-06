package com.ems.rehearse2.repository;

import com.ems.rehearse2.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 2. Second
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
}
