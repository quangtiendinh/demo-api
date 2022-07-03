package com.demo.api.core.expections.dto.response;

import com.demo.api.core.expections.dto.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private ResultCode code;

    private String message;

    private String path;

    private LocalDateTime timestamp = LocalDateTime.now();

}
