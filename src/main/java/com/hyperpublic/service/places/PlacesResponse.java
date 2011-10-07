package com.hyperpublic.service.places;

import com.hyperpublic.domain.Place;

import java.util.Set;

/**
 * @author @peetersn
 */
public class PlacesResponse {

    private Set<Place> response;

    public Set<Place> getResponse() {
        return response;
    }

    public void setResponse(Set<Place> response) {
        this.response = response;
    }
}
