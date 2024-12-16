package me.byungju.springbootdeveloper.repository;

import me.byungju.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

    public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);


    }

