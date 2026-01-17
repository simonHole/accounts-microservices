package com.thesis.accounts_microservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Data
@AllArgsConstructor
public class ResponseDTO {
    @Schema(
            name = "Status Code",
            description = "HTTP Status code in response"
    )
    private String statusCode;
    @Schema(
            name = "Status Message",
            description = "HTTP Status message in response"
    )
    private String statusMessage;
}
