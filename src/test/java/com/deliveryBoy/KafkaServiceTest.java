package com.deliveryBoy;

import com.deliveryBoy.configuration.AppConstants;
import com.deliveryBoy.service.KafkaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class KafkaServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    private Logger logger;

    @InjectMocks
    private KafkaService kafkaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateLocation_shouldSendMessageToKafka() {
        // Arrange
        String location = "Location1";
        when(kafkaTemplate.send(AppConstants.LOCATION, location)).thenReturn(null); // Mocking send method

        // Act
        boolean result = kafkaService.updateLocation(location);

        // Assert
        assertTrue(result, "Expected updateLocation to return true");
        verify(kafkaTemplate, times(1)).send(AppConstants.LOCATION, location);
        verify(logger, times(1)).info("Message produced");
    }
}

