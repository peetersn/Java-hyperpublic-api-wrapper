package com.hyperpublic.service.places;

import com.hyperpublic.domain.Place;

/**
 * @author @peetersn
 */
public interface PlacesService {

    /**
     * Calls the Places endpoint and returns a collect of Place
     *
     * @param lat Latitude (as String)
     * @param lon Longitude (as String)
     * @return an array of Place objects
     */
    Place[] getPlaces(String lat, String lon);
}
