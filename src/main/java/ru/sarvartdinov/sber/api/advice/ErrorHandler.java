package ru.sarvartdinov.sber.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sarvartdinov.sber.exception.GroupsValidationException;

@ControllerAdvice
public class ErrorHandler {

    private static final String UNEXPECTED_ERROR = "Непредвиденная ошибка обработки запроса: ";

    @ExceptionHandler({GroupsValidationException.class})
    public ResponseEntity<String> handleException(GroupsValidationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return new ResponseEntity<>(UNEXPECTED_ERROR + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
