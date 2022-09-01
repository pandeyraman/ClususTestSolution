package com.clusus.clusustestsolution.error;

import com.clusus.clusustestsolution.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FXDealNotFoundException.class)
    public ResponseEntity<ErrorMessage> dealNotFoundException(FXDealNotFoundException exception, WebRequest webRequest) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(FXDealAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> dealAlreadyExistsException(FXDealAlreadyExistsException exception, WebRequest webRequest) {
        ErrorMessage message = new ErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(FXDealInvalidDataException.class)
    public ResponseEntity<ErrorMessage> invalidDealDataException(FXDealInvalidDataException exception, WebRequest webRequest) {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
