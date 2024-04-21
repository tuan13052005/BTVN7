package com.tn.controller;

import com.tn.entity.Account;
import com.tn.entity.Product;
import com.tn.repository.ProductRepository;
import com.tn.req.ProductReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @PostMapping
    public ResponseEntity<?> createAt(@RequestBody Product product) {
        productRepo.save(product);
        return new ResponseEntity<>("Create Succesfully!\n" + product,HttpStatus.OK);
    }

    @PutMapping("{productName}")
    public ResponseEntity<?> updateAt(@RequestBody ProductReq productReq,
                                      @PathVariable String productName){
        Product product = productRepo.findByProductName(productName);
        if (product == null) {
            return new ResponseEntity<>("Not found Account with email: " + productName, HttpStatus.BAD_REQUEST);
        }
        product.setPrice(productReq.getPrice());
        product.setPriceSale(productReq.getPriceSale());
        product.setProductDescription(productReq.getProductDescription());
        productRepo.save(product);
        return new ResponseEntity<>("Update successfully!\n " + product, HttpStatus.OK);
    }
}
