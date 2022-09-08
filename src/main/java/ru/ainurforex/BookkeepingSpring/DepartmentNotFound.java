package ru.ainurforex.BookkeepingSpring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentNotFound extends RuntimeException {
    public DepartmentNotFound() {
    }

}
