package com.stackroute.muzixApp.service;

import com.stackroute.muzixApp.domain.Track;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track user) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(user.getTrackID())){
            throw new TrackAlreadyExistsException("Already Exists"+user.getTrackID());
        }
        Track track= trackRepository.save(user);
        return  track;
    }

    @Override
    public List<Track> getAllTracks() {
       return  trackRepository.findAll();
    }

    @Override
    public Track getTrackByID(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track Does Not Exist");
        }
        Track track= trackRepository.findById(id).get();

        return track;
    }

    @Override
    public Track updateTrack(Track track) {
        Track updateTrack= trackRepository.save(track);
        return updateTrack;
    }

    @Override
    public void deleteByID(Track track)  {
        trackRepository.deleteById(track.getTrackID());
    }

    @Override
    public List<Track> findTrackByName(String trackName)  {
        return trackRepository.getByName(trackName);
    }
}
