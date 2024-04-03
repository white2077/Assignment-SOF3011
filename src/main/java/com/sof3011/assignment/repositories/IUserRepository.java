package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
