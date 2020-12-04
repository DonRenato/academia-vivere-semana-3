package com.academiavivere.semana3.repositories;

import com.academiavivere.semana3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Iterable<User> findByNameAndEmail(String name, String email);
    Iterable<User> findByName(String name);
    Iterable<User> findByEmail(String email);
    User findByLogin(String login);
}
