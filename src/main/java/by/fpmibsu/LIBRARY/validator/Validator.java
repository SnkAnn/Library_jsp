package by.fpmibsu.LIBRARY.validator;

public interface Validator<T> {
    ValidationResult isValid(T object);
}
