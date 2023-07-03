package com.example.registration.repository;

import com.example.registration.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {

    //    @Query(value = "SELECT * FROM User u WHERE u.verificationCode =:code",nativeQuery = true)
    User findByVerificationCode(String code);

    User findByEmailAndPassword(String email, String password);
}
