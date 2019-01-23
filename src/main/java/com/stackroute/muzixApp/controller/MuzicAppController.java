package com.stackroute.muzixApp.controller;

import com.stackroute.muzixApp.domain.User;
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


    //CONSTRUCTOR AUTOWIRING FOR DEPENDENCY INJECTION
    @Autowired
    public MuzicAppController(UserService userService) {
        this.userService = userService;
    }

    //POST MAPPING METHOD TO HANDLE POST REQUEST
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody User track) {
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

    //GET MAPPING METHOD TO HANDLE GET REQUEST
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<User>>(userService.getAllTracks(), HttpStatus.OK);
    }

    //DELETE MAPPING METHOD TO HANDLE DELETE REQUEST
    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) {
        ResponseEntity responseEntity;
        User track1 = userService.getTrackByID(trackId);
        userService.deleteByID(track1);
        responseEntity = new ResponseEntity<String>("Track removed", HttpStatus.OK);
        return responseEntity;
    }

    //GET MAPPING METHOD TO HANDLE GET REQUEST BY ID
    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId)  {
        return new ResponseEntity<User>(userService.getTrackByID(trackId), HttpStatus.OK);
    }

    //PUT MAPPING METHOD TO HANDLE UPDATE OR PUT REQUEST
    @PutMapping("track")
    public ResponseEntity<?> updateComment(@RequestBody User track){
        return new ResponseEntity<User>(userService.updateTrack(track),HttpStatus.OK);
    }
}