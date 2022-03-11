package com.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class DistanceRequest {
    @NotBlank(message = "sourcePostCode is mandatory")
    String sourcePostCode;
    @NotBlank(message = "destinationPostCode is mandatory")
    String destinationPostCode;
}
