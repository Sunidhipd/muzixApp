package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.User;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.exceptions.UserAradyExistsException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveTrack(User user) ;
    List<User> getAllTracks();
    User getTrackByID(int trackId) ;
    User updateTrack(User user);
    void deleteByID(User track);
    List<User> findTrackByName(String track) ;


}
