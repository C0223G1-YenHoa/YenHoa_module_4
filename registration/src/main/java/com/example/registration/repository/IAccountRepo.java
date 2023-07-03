package com.example.registration.repository;

import com.example.registration.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account,Integer> {
    Account findByEmailAndPassword(String email,String password);
}
