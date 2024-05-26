package by.fpmibsu.LIBRARY.exception;

import by.fpmibsu.LIBRARY.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {
@Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}
