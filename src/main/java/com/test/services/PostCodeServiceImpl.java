package com.test.services;

import com.test.entity.PostCode;
import com.test.models.DistanceRequest;
import com.test.models.DistanceResponse;
import com.test.repo.PostCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCodeServiceImpl implements PostCodeService {
    private final PostCodeRepository postCodeRepository;
    private final static double EARTH_RADIUS = 6371; // radius in kilometers

    public PostCodeServiceImpl(PostCodeRepository postCodeRepository) {
        this.postCodeRepository = postCodeRepository;
    }

   public List<PostCode> findAll(){
        return postCodeRepository.findAll();
    }
    public DistanceResponse findDistance(DistanceRequest distanceRequest){
        DistanceResponse distanceResponse = new DistanceResponse();
        PostCode postCodeSource = postCodeRepository.findByName(distanceRequest.getSourcePostCode());
        PostCode postCodeDestination = postCodeRepository.findByName(distanceRequest.getDestinationPostCode());
        double distance = calculateDistance(postCodeSource.getLatitude(),postCodeSource.getLongitude(),
                postCodeDestination.getLatitude(),postCodeDestination.getLongitude());
        distanceResponse.setDistance(distance);
        distanceResponse.setSource(postCodeSource);
        distanceResponse.setDestination(postCodeDestination);
        return distanceResponse;
    }

   public  PostCode findByCode(String postcode){
     return  postCodeRepository.findByName(postcode);
    }

    public void save(PostCode postCode){
        postCodeRepository.save(postCode);
    }

    private double calculateDistance(double latitude, double longitude, double latitude2, double
            longitude2) {
        // Using Haversine formula! See Wikipedia;
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);
        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (EARTH_RADIUS * c);
    }
    private double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }
    private double square(double x) {
        return x * x;
    }
}
