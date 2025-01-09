package com.deliveryBoy;

import com.deliveryBoy.Controller.LocationController;
import com.deliveryBoy.service.KafkaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LocationControllerTest {

    @Mock
    private KafkaService kafkaService;

    @InjectMocks
    private LocationController locationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateLocation_shouldCallKafkaServiceAndReturnResponse() {

        ResponseEntity<?> response = locationController.updateLocation();

        verify(kafkaService, times(1)).updateLocation(anyString());
        assertEquals(200, response.getStatusCodeValue());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Location Updated", responseBody.get("message"));
    }
}
