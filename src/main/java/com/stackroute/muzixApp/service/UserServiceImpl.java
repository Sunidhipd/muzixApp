package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.User;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.exceptions.UserAlreadyExistsException;
import com.stackroute.muzixApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveTrack(User user) throws UserAlreadyExistsException {
        if(userRepository.existsById(user.getTrackID())){
            throw new UserAlreadyExistsException("Already Exists"+user.getTrackID());
        }
        User track=userRepository.save(user);
        return  track;
    }

    @Override
    public List<User> getAllTracks() {
       return  userRepository.findAll();
    }

    @Override
    public User getTrackByID(int id) throws TrackNotFoundException {
        if(!userRepository.existsById(id)){
            throw new TrackNotFoundException("Track Does Not Exist");
        }
        User track=userRepository.findById(id).get();

        return track;
    }

    @Override
    public User updateTrack(User user) {
        User updateTrack=userRepository.save(user);
        return updateTrack;
    }

    @Override
    public void deleteByID(User track)  {
        userRepository.deleteById(track.getTrackID());
    }

    @Override
    public List<User> findTrackByName(String trackName)  {
        return userRepository.getByName(trackName);
    }
}
