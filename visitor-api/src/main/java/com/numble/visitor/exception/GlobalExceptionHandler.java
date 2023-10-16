package com.numble.visitor.exception;

import com.numble.visitor.controller.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({SiteNotFoundException.class, SiteStatisticNotFoundException.class})
    public ApiResponse<Void> handleNotFoundException(Exception e) {
        return ApiResponse.fail(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
