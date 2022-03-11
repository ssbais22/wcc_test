package com.test.services;

import com.test.entity.PostCode;
import com.test.models.DistanceRequest;
import com.test.models.DistanceResponse;

import java.util.List;

public interface PostCodeService {
    List<PostCode> findAll();
     DistanceResponse findDistance(DistanceRequest distanceRequest);
     PostCode findByCode(String postcode);
     void save(PostCode postCode);
}
