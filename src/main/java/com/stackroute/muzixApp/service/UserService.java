package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.Track;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserService {
    public Track saveTrack(Track track) throws UserAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track getTrackByID(int trackId) throws TrackNotFoundException;
    public Track updateTrack(Track track);
    public void deleteByID(Track track);
    public List<Track> findTrackByName(String track) throws TrackNotFoundException;


}
