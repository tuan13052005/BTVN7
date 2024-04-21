package com.tn.controller;
import com.tn.entity.Category;
import com.tn.repository.CategoryRepository;
import com.tn.req.CategoryReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(name = "category" )
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @PostMapping
    public ResponseEntity<?> createAt(@RequestBody Category category) {
        categoryRepo.save(category);
        return new ResponseEntity<>("Create Successfully!\n" + category, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAt(@RequestBody CategoryReq categoryReq,
                                      @PathVariable int id) {
        Category category = categoryRepo.findById(id).orElse(null);
        if (category == null) {
            return new ResponseEntity<>("Not found Account with email: " + id, HttpStatus.BAD_REQUEST);
        }
        category.setCategory(categoryReq.getCategory());
        categoryRepo.save(category);
        return new ResponseEntity<>("Update successfully!\n " + category, HttpStatus.OK);
    }

}
