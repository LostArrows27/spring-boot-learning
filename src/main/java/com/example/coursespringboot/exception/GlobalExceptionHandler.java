//package com.example.coursespringboot.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseEntity<ErrorResponseEntity> handleIllegalStateException(IllegalStateException e) {
//        ErrorResponseEntity errResponse = new ErrorResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);
//    }
//
//}
//
