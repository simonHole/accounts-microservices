package com.thesis.accounts_microservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Error response",
        description = "Schema to hold failed response information"
)
@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    @Schema(
            name = "API Path", example = "http://thesis-bank.com/account?id=1"
    )
    private String apiPath;

    @Schema(
            name = "HTTP Error Status Code", example = "400 BAD_REQUEST",
            description = "HTTP Error Status Code in response"
    )
    private HttpStatus errorCode;

    @Schema(
            name = "HTTP Error Status message", example = "Customer with mobile number 123456789 already exists",
            description = "HTTP Error Status message in response"
    )
    private String errorMessage;

    @Schema(
            name = "HTTP Error Status", example = "2026-01-21T20:21:23.9133867",
            description = "HTTP Error Status timestamp when error occurs"
    )
    private LocalDateTime errorTime;
}
