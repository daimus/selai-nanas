package com.example.userservice.infrastructure.presenter.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    private Response response;
    public ExceptionHandlerController(){
        this.response = new Response();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException, HttpServletRequest request){
        this.response.setError(methodArgumentTypeMismatchException);
        this.response.setHttpCode(400);
        return this.response.getResponse();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleDataNotFoundException(NoSuchElementException noSuchElementException, HttpServletRequest request){
        this.response.setError(noSuchElementException);
        this.response.setHttpCode(404);
        return this.response.getResponse();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException, HttpServletRequest request){
        this.response.setError(httpMessageNotReadableException);
        this.response.setHttpCode(400);
        return this.response.getResponse();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request){
        this.response.setError(methodArgumentNotValidException);
        this.response.setHttpCode(400);
        this.response.setMessage("Invalid input");
        this.response.setErrors(methodArgumentNotValidException);
        return this.response.getResponse();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleDataNotFoundException(Exception exception, HttpServletRequest request){
        this.response.setError(exception);
        this.response.setHttpCode(400);
        return this.response.getResponse();
    }
}
