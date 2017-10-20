//package com.perficient.SpringH2Sample.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;}
//@RestControllerAdvice
//public class ExceptionController {
//
//
//
//    @ExceptionHandler(value = { Exception.class })
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiErrorResponse yearConstraintViolationExceptio(YearViolationException ex) {
//
//        return new ApiErrorResponse(400, 5001, ex.getMessage());
//    }
//}