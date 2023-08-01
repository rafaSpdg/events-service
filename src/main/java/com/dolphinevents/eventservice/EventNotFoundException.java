package com.dolphinevents.eventservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason= "Event doesn't exists.")
public class EventNotFoundException extends Throwable {
    
    public EventNotFoundException(String message) {
        super(message);
    }
}
