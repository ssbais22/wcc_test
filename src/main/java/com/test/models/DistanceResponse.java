package com.test.models;

import com.test.entity.PostCode;
import lombok.Data;

@Data
public class DistanceResponse {
    double distance;
    String unit="KM";
    PostCode source;
    PostCode destination;
}
