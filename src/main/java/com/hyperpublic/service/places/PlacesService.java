package com.hyperpublic.service.places;

/**
 * @author @peetersn
 */
public interface PlacesService {

    /**
     * Calls the Places endpoint and returns a collect of Place
     * @param lat Latitude (as String)
     * @param lon Longitude (as String)
     * @return a Set of Place objects
     */
    PlacesResponse callEndpoint(String lat, String lon);
}
