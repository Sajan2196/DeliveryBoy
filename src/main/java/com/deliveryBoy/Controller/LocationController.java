package com.deliveryBoy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deliveryBoy.service.KafkaService;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {

        this.kafkaService.updateLocation("(Longitude-"+Math.round(Math.random()*100)+",Latitude-"+Math.round(Math.random()*100)+")");
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }
}
