package com.example.twitterBacked.controller;

import com.example.twitterBacked.model.UserDetails;
import com.example.twitterBacked.repository.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ControllerTest {

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Logger log;

    @InjectMocks
    private TwitterController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes annotated fields
    }

    @Test
    public void createUserSuccessTest(){
        UserDetails userDetails = new UserDetails(1, "john@example.com", "John Doe", 25, "securePassword");

        ResponseEntity<String> response = controller.createUser(userDetails);

        verify(dataRepository,times(1)).save(any());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User created successfully", response.getBody());

    }

    @Test
    public void createUserErrorTest(){
        UserDetails userDetails = new UserDetails(1, null, "John Doe", 25, "securePassword");

        ResponseEntity<String> response = controller.createUser(userDetails);

        verify(log,times(1)).error(any());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid user details", response.getBody());

    }
}
