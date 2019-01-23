package com.stackroute.muzixApp.repository;

import com.stackroute.muzixApp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Track,Integer> {
    @Query("Select t from Track t where t.trackName=?1")
    public List<Track> getByName(String track);
}
