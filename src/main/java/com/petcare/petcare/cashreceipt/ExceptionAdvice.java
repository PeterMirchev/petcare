package com.petcare.petcare.cashreceipt;
import com.petcare.petcare.cashreceipt.controller.InvalidJsonInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NonExistingEntityException.class)
    public ResponseEntity<String> handleNonExistingEntityException(NonExistingEntityException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<InvalidJsonInput>> handleException(MethodArgumentNotValidException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception
                        .getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(e -> InvalidJsonInput.builder()
                                .rejectedValue(e.getRejectedValue() != null ? e.getRejectedValue().toString() : "null")
                                .violatedField(e.getField())
                                .description(e.getDefaultMessage())
                                .build())
                        .toList());
    }



}
