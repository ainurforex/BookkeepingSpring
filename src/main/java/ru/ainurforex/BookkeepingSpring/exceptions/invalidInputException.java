package ru.ainurforex.BookkeepingSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class invalidInputException extends RuntimeException {
    public invalidInputException(String message) {
        super(message);
    }
}


