package com.test.controller;

import com.test.entity.PostCode;
import com.test.models.DistanceRequest;
import com.test.models.DistanceResponse;
import com.test.services.PostCodeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
@Log4j2
public class PostCodeController extends BaseRestController {
    private final PostCodeService postCodeService;

    public PostCodeController(PostCodeService postCodeService) {
        this.postCodeService = postCodeService;
    }


    @GetMapping("/distance/{source}/{destination}")
    // return the distance between post code with other details
    public ResponseEntity<DistanceResponse> createShipment(@PathVariable String source,@PathVariable String destination ) {
        DistanceRequest distanceRequest = new DistanceRequest(source,destination);
        return new ResponseEntity<>(postCodeService.findDistance(distanceRequest), HttpStatus.OK);
    }

    @GetMapping("/postcodes/")
    // return all the zipcode
    public ResponseEntity<?> getAll() {
        List<PostCode> postleCodes = postCodeService.findAll();
        return new ResponseEntity<>(postleCodes, HttpStatus.OK);
    }
    @PostMapping("/postcode/")
    // return all the zipcode
    public ResponseEntity<PostCode> save(@Valid @RequestBody PostCode postCode) {
        postCodeService.save(postCode);
        return new ResponseEntity<>(postCode, HttpStatus.OK);
    }

    @GetMapping("/postcode/{postcode}")
    // return all the zipcode
    public ResponseEntity<PostCode> getPostCode(@PathVariable String postcode) {
        PostCode postCode = postCodeService.findByCode(postcode);
        return new ResponseEntity<>(postCode, HttpStatus.OK);
    }

}
