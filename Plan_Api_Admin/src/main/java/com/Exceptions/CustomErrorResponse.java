package com.Exceptions;



import java.time.LocalDateTime;

public class CustomErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;

    public CustomErrorResponse(LocalDateTime timestamp, int status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    // getters and setters
}

