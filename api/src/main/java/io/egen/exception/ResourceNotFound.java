package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//-------------Exception for Resource Not Found------------//
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message){super(message);}
}
