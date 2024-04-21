package com.tn.sevice;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountSeviceImpl implements AccountSevice{
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: " + username);
        Account account = accountRepo.findByUsername(username);

        if (account == null ){
            throw new UsernameNotFoundException("Not found Account");
        }

        return new User(username,account.getPassword(), Collections.emptyList());
    }
}
