package com.authenticator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.authenticator.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findAppUserByUserName(String name);
}
