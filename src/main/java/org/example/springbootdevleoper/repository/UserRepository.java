package org.example.springbootdevleoper.repository;

import org.example.springbootdevleoper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public  User save( User user);
    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);
}
