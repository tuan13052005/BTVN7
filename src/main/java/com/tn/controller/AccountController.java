package com.tn.controller;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import com.tn.req.AccountReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountRepo.findAll();
        return new ResponseEntity<>("Show Account: " + accounts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAt(@RequestBody Account account) {
        String password0 = new BCryptPasswordEncoder().encode(account.getPassword());
        account.setPassword(password0);
        accountRepo.save(account);
        return new ResponseEntity<>("Create Successfully!\n" + account,HttpStatus.OK);
    }

    @PutMapping("{email}")
    public ResponseEntity<?> updateAt(@RequestBody AccountReq accountReq,
                                      @PathVariable String email) {
        Account account = accountRepo.findByEmail(email);
        if (account == null) {
            return new ResponseEntity<>("Not found Account with email: " + email, HttpStatus.BAD_REQUEST);
        }
        account.setFullName(accountReq.getFullName());
        account.setUsername(accountReq.getUsername());
        account.setPassword(accountReq.getPassword());
        account.setEmail(accountReq.getEmail());
        accountRepo.save(account);
        return new ResponseEntity<>("Update successfully!\n " + account, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Account account = accountRepo.findById(id).orElse(null);
        if (account == null) {
            return new ResponseEntity<>("Not found Account with id: " + id, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Account with id " + id + "\n" + account, HttpStatus.OK);
    }
}
