package com.stackroute.muzixApp.repository;

import com.stackroute.muzixApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
