package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.entity.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class
            , DuplicateUserNameException.class
            , LoginException.class
            , ConstraintViolationException.class})
    public ResponseEntity handleValid(Exception ex) {
        String message = ex.getMessage();
        int code = HttpStatus.BAD_REQUEST.value();
        if (ex instanceof MethodArgumentNotValidException) {
            BindingResult exceptions = ((MethodArgumentNotValidException) ex).getBindingResult();
            if (exceptions.hasErrors()) {
                List<ObjectError> errors = exceptions.getAllErrors();
                if (!errors.isEmpty()) {
                    message = errors.get(0).getDefaultMessage();
                }
            }
        }
        if (ex instanceof LoginException) {
            code = HttpStatus.NOT_FOUND.value();
        }
        Error error = new Error(code, message);
        return ResponseEntity.badRequest().body(error);
    }
}
