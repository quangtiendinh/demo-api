package com.demo.api.core.expections.handler;

import com.demo.api.core.expections.DuplicationResourceException;
import com.demo.api.core.expections.NotFoundResourceException;
import com.demo.api.core.expections.dto.ResultCode;
import com.demo.api.core.expections.dto.response.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundResourceException.class)
    public ResponseEntity<Object>  handleNotFoundResourceException(NotFoundResourceException e, WebRequest request) {
        log.error("handleNotFoundResourceException", e);
        ApiErrorResponse response = ApiErrorResponse.builder()
                .code(ResultCode.NOT_FOUND_RESOURCE)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getContextPath())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicationResourceException.class)
    public ResponseEntity<Object>  handleDuplicationResourceException(DuplicationResourceException e, WebRequest request) {
        log.error("handleDuplicationResourceException", e);
        ApiErrorResponse response = ApiErrorResponse.builder()
                .code(ResultCode.DUPLICATION_RESOURCE)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getContextPath())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
