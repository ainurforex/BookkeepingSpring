package ru.ainurforex.BookkeepingSpring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentNotFound extends RuntimeException {
    public DepartmentNotFound() {
    }

    public DepartmentNotFound(String message) {
        super(message);
    }

    public DepartmentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFound(Throwable cause) {
        super(cause);
    }

    public DepartmentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
