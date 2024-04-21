package com.tn.repository;

import com.tn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);
    Product findByPrice(int price);
    Product findByPriceSale(int priceSale);
    Product findByProductDescription(String productDescription);
}
