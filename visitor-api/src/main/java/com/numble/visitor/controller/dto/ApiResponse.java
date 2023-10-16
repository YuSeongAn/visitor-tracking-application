package com.numble.visitor.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private Boolean success;
    private Integer status;
    private String message;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, true, HttpStatus.OK.value(), null);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(null, true, HttpStatus.OK.value(), null);
    }

    public static ApiResponse<Void> fail(HttpStatus httpStatus, String message) {
        return new ApiResponse<>(null, false, httpStatus.value(), message);
    }
}
