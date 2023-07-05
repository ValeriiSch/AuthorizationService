package ru.netology.authorizationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println("[unauthorizedUserHandler] " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
