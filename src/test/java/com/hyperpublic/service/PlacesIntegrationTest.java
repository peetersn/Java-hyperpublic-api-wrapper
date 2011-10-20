package com.hyperpublic.service;

import com.hyperpublic.domain.Place;
import com.hyperpublic.service.places.PlacesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class PlacesIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlacesIntegrationTest.class);

    private PlacesServiceImpl placesService;

    @Before
    public void before() {
        placesService = new PlacesServiceImpl();
    }

    @Test
    public void simpleCall() {
        String lat = "37.7777";
        String lon = "-122.4086";
        Place[] res = placesService.getPlaces(lat, lon);
        assertNotNull(res);
        LOGGER.info("{}", res);
        System.out.println(res);

        for (Place p : res) {
            System.out.println(p.getDisplayName());
        }
    }
}
