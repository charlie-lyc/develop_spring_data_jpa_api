package com.ems.rehearse2.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * 1. First
 *  - JPA: table, entity, id, generatedValue, column
 *  - Lombok: data(including getters, setters, equals, hashCode, toString), noArgsConstructor, AllArgsConstructor
 *  - Hibernate: dynamicUpdate
 */
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return quantity == product.quantity && Double.compare(price, product.price) == 0 && Objects.equals(id, product.id) && Objects.equals(name, product.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, quantity, price);
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }

}
