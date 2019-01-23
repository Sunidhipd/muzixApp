package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.User;
import com.stackroute.muzixApp.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserService {
    User saveTrack(User user) throws UserAlreadyExistsException;
    List<User> getAllTracks();
    User getTrackByID(int trackId) ;
    User updateTrack(User user);
    void deleteByID(User track);
    User findTrackByName(String track) ;


}
