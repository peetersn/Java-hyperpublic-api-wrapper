package com.hyperpublic.service;

import com.hyperpublic.domain.Place;
import com.hyperpublic.service.places.PlacesResponse;
import com.hyperpublic.service.places.PlacesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * This is an integration test of the serfvice
 *
 * @author @peetersn
 */
public class PlacesIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlacesIntegrationTest.class);

    private PlacesServiceImpl placesService;

    @Before
    public void before() {
        placesService = new PlacesServiceImpl();
    }

    @Test
    public void simpleCall() {
        final String lat = "37.7777";
        final String lon = "-122.4086";
        PlacesResponse res = placesService.callEndpoint(lat, lon);
        assertNotNull(res);
        assertNotNull(res.getResponse());
        for (Place place : res.getResponse()) {
            LOGGER.info("Found: {}", place);
        }
    }
}
