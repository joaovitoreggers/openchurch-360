package com.adqpsystem.api.user.repositories;

import com.adqpsystem.api.common.entities.Email;
import com.adqpsystem.api.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(Email email);
    List<User> findByActiveTrueAndEmail(Email email);
    List<User> findByActiveTrueAndName(String name);
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();
}
