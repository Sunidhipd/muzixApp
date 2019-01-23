package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.Track;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.exceptions.UserAlreadyExistsException;
import com.stackroute.muzixApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Track saveTrack(Track user) throws UserAlreadyExistsException {
        if(userRepository.existsById(user.getTrackID())){
            throw new UserAlreadyExistsException("Already Exists"+user.getTrackID());
        }
        Track track=userRepository.save(user);
        return  track;
    }

    @Override
    public List<Track> getAllTracks() {
       return  userRepository.findAll();
    }

    @Override
    public Track getTrackByID(int id) throws TrackNotFoundException {
        if(!userRepository.existsById(id)){
            throw new TrackNotFoundException("Track Does Not Exist");
        }
        Track track=userRepository.findById(id).get();

        return track;
    }

    @Override
    public Track updateTrack(Track track) {
        Track updateTrack=userRepository.save(track);
        return updateTrack;
    }

    @Override
    public void deleteByID(Track track)  {
        userRepository.deleteById(track.getTrackID());
    }

    @Override
    public List<Track> findTrackByName(String trackName)  {
        return userRepository.getByName(trackName);
    }
}
