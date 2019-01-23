package com.stackroute.muzixApp.repository;

import com.stackroute.muzixApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("Select t from User t where t.trackName=?1")
    public User getByName(String track);
}
