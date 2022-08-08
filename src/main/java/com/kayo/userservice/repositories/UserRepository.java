package com.kayo.userservice.repositories;

import com.kayo.userservice.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
