package com.example.balo_center.exception;

import com.example.balo_center.domain.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Not Found",
                "Resource Not Found",
                resourceNotFoundException.getMessage(),
                webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleGenericException(Exception exception, WebRequest webRequest) {
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal Server Error",
                "Internal Server Error",
                exception.getMessage(),
                webRequest);
    }

    private ApiResponse<Object> buildErrorResponse(HttpStatus status, String error, String message,
                                                   String exceptionMessage, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("Timestamp", LocalDateTime.now());
        body.put("Status", status.value());
        body.put("Error", error);
        body.put("Message", exceptionMessage);
        body.put("Path", webRequest.getDescription(false).replace("uri", ""));

        return new ApiResponse<>(status.value(), message, body);
    }
}

