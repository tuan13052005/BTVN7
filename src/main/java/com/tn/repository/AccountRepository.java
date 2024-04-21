package com.tn.repository;

import com.tn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByFullName(String fullName);
    Account findByUsername(String username);
    Account findByPassword(String password);
    Account findByEmail(String email);
}
