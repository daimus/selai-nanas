package com.example.orderservice.infrastructure.presenter.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    private Exception exception;
    private HttpServletRequest request;
    private int httpCode = 500;
    private ResponseEntity<Object> formatResponse(){
        this.exception.printStackTrace();
        Response response = new Response();
        response.setPath(this.request.getRequestURI());
        response.setHttpCode(this.httpCode);
        response.setError(this.exception);
        return response.getResponse();
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException, HttpServletRequest request){
        this.exception = methodArgumentTypeMismatchException;
        this.request = request;
        this.httpCode = 400;
        return formatResponse();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleDataNotFoundException(NoSuchElementException noSuchElementException, HttpServletRequest request){
        this.exception = noSuchElementException;
        this.request = request;
        this.httpCode = 404;
        return formatResponse();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException, HttpServletRequest request){
        this.exception = httpMessageNotReadableException;
        this.request = request;
        this.httpCode = 400;
        return formatResponse();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request){
        // TODO: Show field error
        log.info("method argument not valid");
        this.exception = methodArgumentNotValidException;
        Object[] s = methodArgumentNotValidException.getDetailMessageArguments();
        List<ObjectError> c = methodArgumentNotValidException.getAllErrors();
        this.request = request;
        this.httpCode = 400;
        return formatResponse();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleDataNotFoundException(Exception exception, HttpServletRequest request){
        System.out.println(exception.getClass());
        this.exception = exception;
        this.request = request;
        return formatResponse();
    }
}
