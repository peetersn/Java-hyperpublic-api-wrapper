package com.hyperpublic.service.places;

import com.hyperpublic.domain.Auth;

/**
 * @author @peetersn
 */
public interface PlacesService {

    /**
     * Calls the Places endpoint and returns a collect of Place
     * @param lat Latitude (as String)
     * @param lon Longitude (as String)
     * @param auth contains the authorization tokens
     * @return a Set of Place objects
     */
    PlacesResponse callEndpoint(String lat, String lon, Auth auth );
}
