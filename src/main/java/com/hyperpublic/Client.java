package com.hyperpublic;

import com.hyperpublic.domain.Place;
import com.hyperpublic.service.places.PlacesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the main client.
 *
 * @author @peetersn
 */
public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {

        PlacesServiceImpl placesService = new PlacesServiceImpl();

        Place[] places = placesService.getPlaces("37.7777", "-122.4086");

        for (Place place : places) {
            LOGGER.info("Found: {}", place);
        }
    }

}
