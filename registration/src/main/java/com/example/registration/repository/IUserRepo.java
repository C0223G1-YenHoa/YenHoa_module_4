package com.example.registration.repository;

import com.example.registration.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {

    User findByVerificationCode(String code);

    User findByEmail(String email);

}
