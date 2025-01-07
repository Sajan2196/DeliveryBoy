package com.deliveryBoy.service;

import com.deliveryBoy.configuration.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {
//        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        this.kafkaTemplate.send(AppConstants.LOCATION, location);
        this.logger.info("Message produced");
        return true;
    }
}
