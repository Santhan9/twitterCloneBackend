package com.example.twitterBacked.controller;

import com.example.twitterBacked.dao.UserDetailsDao;
import com.example.twitterBacked.model.UserDetails;
import com.example.twitterBacked.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("twitter")
public class TwitterController {
    Logger log = LoggerFactory.getLogger(TwitterController.class);

    @Autowired
    DataRepository dataRepository;

    @PostMapping("/userSignUp")
    public ResponseEntity<String> createUser(@RequestBody UserDetails userDetails) {
        log.info("Received request for sign-up for user with email: {}", userDetails.getEmail());

        try {
            // Validation
            if (isInvalidUserDetails(userDetails)) {
                log.error("Invalid user details received for sign-up");
                return new ResponseEntity<>("Invalid user details", HttpStatus.BAD_REQUEST);
            }

            // Convert to UserDetailsDao and save to the database
            UserDetailsDao userDetailsDao = new UserDetailsDao(
                    userDetails.getId(),
                    userDetails.getEmail(),
                    userDetails.getName(),
                    userDetails.getAge(),
                    userDetails.getPassword()
            );
            dataRepository.save(userDetailsDao);

            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error during user sign-up", e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestParam("email") String email,@RequestParam("password") String Password){
        log.info("Received request for login for user with email: {}",email);
        return new ResponseEntity<String>("",HttpStatus.OK);

    }

    private boolean isInvalidUserDetails(UserDetails userDetails) {
        return userDetails == null ||
                userDetails.getEmail() == null ||
                userDetails.getName() == null ||
                userDetails.getPassword() == null;
    }
}

