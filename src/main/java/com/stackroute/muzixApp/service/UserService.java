package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.User;

import java.util.List;

public interface UserService {

    //The functionalies we want the UserService to have are made as method here below
    User saveTrack(User user) ;
    List<User> getAllTracks();
    User getTrackByID(int trackId) ;
    User updateTrack(User user);
    void deleteByID(User track);
    List<User> findTrackByName(String track) ;


}
