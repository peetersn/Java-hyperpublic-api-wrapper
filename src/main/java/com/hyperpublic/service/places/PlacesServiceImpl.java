package com.hyperpublic.service.places;

import com.hyperpublic.domain.Constants;
import com.hyperpublic.domain.Place;
import com.hyperpublic.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * This is the implementation of the Places service
 *
 * @author @peetersn
 */
public class PlacesServiceImpl extends AbstractService implements PlacesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlacesServiceImpl.class);

    public Place[] getPlaces(String lat, String lon) {

        if (!init) { //this is a bit of hack for SSL trust
            trustSelfSignedSSL();
        }

        RestTemplate restTemplate = createTemplate();
        Place[] res = restTemplate.getForObject(Constants.BASE_URL_PLACES_ENDPOINT + "?client_id={clientId}&client_secret={clientSecret}&lat={lat}&lon={lon}&limit=50",
                Place[].class, Constants.CLIENT_ID, Constants.CLIENT_SECRET, lat, lon);

        return res;
    }

}
