package com.tn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product",uniqueConstraints = @UniqueConstraint(columnNames = "productName"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String productName;

    private int price;

    private int priceSale;

    private String productDescription;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", priceSale=" + priceSale +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
