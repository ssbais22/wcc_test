package com.test.scm;

import com.test.entity.PostCode;
import com.test.models.DistanceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class PostcodeIntegrationTests {
    public static final String ADMIN = "admin";
    final String baseURL = "http://localhost:7001/api/";

    private PostCode buildPostCode(String code, int weight, int id) {
        PostCode postCode = new PostCode();
        postCode.setPostalCode(code);
        postCode.setLongitude(40);
        postCode.setLatitude(80);
        return postCode;
    }

    @Test
    void testDistance() {
        PostCode postCode = buildPostCode("TEST01_01", 30, 40);
        HttpEntity<PostCode> request = new HttpEntity<>(postCode);
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add(
                new BasicAuthenticationInterceptor("admin", "admin123"));
        ResponseEntity<DistanceResponse> getForDistance = template.getForEntity(baseURL + "distance/AB10 1XG/AB21 0AL/", DistanceResponse.class);
        Assert.isTrue(getForDistance.getBody().getDistance() >13, "Distance is matching ");
        Assert.isTrue(getForDistance.getStatusCode() == HttpStatus.OK, "Distance is matching ");
    }

}
