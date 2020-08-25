package org.csystem.app.exception.handler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestAppExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        var appError = new RestAppError("Invalid Json Format", HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getValue());

        return ResponseEntity.status(appError.getHttpStatus()).body(appError);
    }
}
