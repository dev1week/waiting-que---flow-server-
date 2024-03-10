package com.example.flow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ServerExceptionResponse {

    private String code;
    private String reason;
}
