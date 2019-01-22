package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.User;
import com.stackroute.muzixApp.exceptions.UserAradyExistsException;
import com.stackroute.muzixApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveTrack(User user) throws UserAradyExistsException {
        if (userRepository.existsById(user.getTrackID())) {
          throw new UserAradyExistsException("User already exists");
        }
        User savedUser=userRepository.save(user);
        if(savedUser==null){
            throw new UserAradyExistsException("User null");
        }
        return  savedUser;
    }

    @Override
    public List<User> getAllTracks() {
       return  userRepository.findAll();
    }

    @Override
    public User getTrackByID(int id) {
        User track=userRepository.findById(id).get();
        return track;
    }

    @Override
    public User updateTrack(User user) {
        User updateTrack=userRepository.save(user);
        return updateTrack;

    }


    @Override
    public void deleteByID(User track) {
        userRepository.deleteById(track.getTrackID());

    }
}
