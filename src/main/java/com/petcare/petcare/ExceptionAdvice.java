package com.petcare.petcare;
import com.petcare.petcare.cashreceipt.controller.GenericErrorResponse;
import com.petcare.petcare.cashreceipt.controller.GenericErrorResponseInvalidInput;
import com.petcare.petcare.cashreceipt.controller.InvalidJsonInput;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NonExistingEntityException.class)
    public ResponseEntity<String> handleNonExistingEntityException(NonExistingEntityException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<InvalidJsonInput>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GenericErrorResponseInvalidInput> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(toGenericResponse(exception));
    }

    private GenericErrorResponseInvalidInput toGenericResponse(MethodArgumentTypeMismatchException exception) {
        return GenericErrorResponseInvalidInput.builder()
                .exceptionMessage(exception.getMessage())
                .exceptionName(exception.getClass().getSimpleName())
                .requiredType(Objects.requireNonNull(exception.getRequiredType()).getName())
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GenericErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body((GenericErrorResponse) toGenericExceptionResponse(exception));
    }

    private Object toGenericExceptionResponse(DataIntegrityViolationException exception) {
        return GenericErrorResponse.builder()
                .exceptionName(exception.getClass().getSimpleName())
                .exceptionMessage(exception.getMessage())
                .build();
    }

}
