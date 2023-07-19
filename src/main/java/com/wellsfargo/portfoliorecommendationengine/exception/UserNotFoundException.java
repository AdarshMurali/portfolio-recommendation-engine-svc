package com.wellsfargo.portfoliorecommendationengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException  extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }
}
