package com.stackroute.muzixApp.controller;

import com.stackroute.muzixApp.domain.Track;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.exceptions.UserAlreadyExistsException;
import com.stackroute.muzixApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MuzicAppController {
    UserService userService;


    @Autowired
    public MuzicAppController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws UserAlreadyExistsException {
        ResponseEntity responseEntity;

//        try {
            userService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
//        } catch (UserAlreadyExistsException ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            ex.printStackTrace();
//        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(userService.getAllTracks(), HttpStatus.OK);
    }

    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) throws TrackNotFoundException {
        ResponseEntity responseEntity;
            Track track1 = userService.getTrackByID(trackId);
            userService.deleteByID(track1);
            responseEntity = new ResponseEntity<String>("Track removed", HttpStatus.OK);

        return responseEntity;
    }

   //This method is used to
    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId) throws TrackNotFoundException {
        return new ResponseEntity<Track>(userService.getTrackByID(trackId), HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateComment(@RequestBody Track track){
        return new ResponseEntity<Track>(userService.updateTrack(track),HttpStatus.OK);
    }
}