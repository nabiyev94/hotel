package net.javaguides.springboot.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // we can also use this annotation in Rest API,
// we no need to repeat this anno. in all rest api which throw the exception of ResourceNotFoundException
// the rest api should return this ResourceNotFoundException message to the client with status not found
// => we add in the annotation the (value = ..)

public class ResourceNotFoundException extends RuntimeException{ // when table not exist


    public ResourceNotFoundException(String message) {
        super(message);
    }
}
