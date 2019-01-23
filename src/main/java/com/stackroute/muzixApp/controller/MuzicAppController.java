package com.stackroute.muzixApp.controller;

import com.stackroute.muzixApp.domain.User;
import com.stackroute.muzixApp.exceptions.UserAlreadyExistsException;
import com.stackroute.muzixApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
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
    public ResponseEntity<?> saveTrack(@RequestBody User track) throws UserAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            userService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (UserAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try {
            responseEntity= new ResponseEntity<List<User>>(userService.getAllTracks(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
        }

    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) {
        ResponseEntity responseEntity;
        try {
            User track1 = userService.getTrackByID(trackId);
            userService.deleteByID(track1);
            responseEntity = new ResponseEntity<String>("Track removed", HttpStatus.OK);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId) {
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<User>(userService.getTrackByID(trackId), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateComment(@RequestBody User track){
        ResponseEntity responseEntity;
        try {
            userService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("Success Updation", HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping(value = "/trackName/{getName}")
    public ResponseEntity<Track> getByTrackName(@PathVariable String getName)
    {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<User>(userService.findTrackByName(getName),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}