package com.hyperpublic.service.places;

import com.hyperpublic.domain.Constants;
import com.hyperpublic.domain.Place;
import com.hyperpublic.service.AbstractService;
import com.hyperpublic.util.http.GenericHttpsClient;
import com.hyperpublic.util.json.PlacesJSONParser;

import java.util.Set;

/**
 * This is the implementation of the Places service
 *
 * @author @peetersn
 */
public class PlacesServiceImpl extends AbstractService implements PlacesService {

    private final GenericHttpsClient client = new GenericHttpsClient();

    @Override
    public PlacesResponse callEndpoint(String lat, String lon) {
        PlacesResponse response = new PlacesResponse();
        PlacesJSONParser jsonUtil = new PlacesJSONParser();
        String jsonResponse = client.call(createQueryLatLon(lat, lon));
        Set<Place> places = jsonUtil.formatResponse(jsonResponse);
        response.setResponse(places);
        return response;
    }

    /**
     * Builds the query for a given lat/lon
     *
     * @param lat latitude as String xxx.xxxx
     * @param lon longitude as String xxx.xxx
     * @return a String with the URL signed with the ID and SECRET
     */
    private String createQueryLatLon(String lat, String lon) {
        StringBuilder urlBuilder = new StringBuilder();
        return urlBuilder.append(
                Constants.BASE_URL_PLACES_ENDPOINT).
                append("?lat").append("=").append(lat).
                append("&lon").append("=").append(lon).
                append("&limit").append("=").append("50").
                append("&client_id").append("=").append(Constants.CLIENT_ID).
                append("&client_secret").append("=").append(Constants.CLIENT_SECRET).toString();
    }
}
