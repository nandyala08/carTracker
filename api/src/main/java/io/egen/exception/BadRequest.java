package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//-------------Exception for Bad Request------------//
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException{
    public BadRequest(String message){super(message);}
}
