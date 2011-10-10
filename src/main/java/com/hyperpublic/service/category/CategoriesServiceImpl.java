package com.hyperpublic.service.category;

import com.hyperpublic.domain.Auth;
import com.hyperpublic.domain.Category;
import com.hyperpublic.domain.Constants;
import com.hyperpublic.service.AbstractService;
import com.hyperpublic.util.http.GenericHttpsClient;
import com.hyperpublic.util.json.CategoriesJSONParser;

import java.util.Set;

/**
 * This is the implementation of the Category endpoint:
 * <p/>
 * http://developer.hyperpublic.com/categories/all-categories/
 *
 * @author @peetersn
 */
public class CategoriesServiceImpl extends AbstractService implements CategoriesService {

    private final GenericHttpsClient client = new GenericHttpsClient();

    @Override
    public CategoriesResponse callEndpoint(Auth auth) {
        CategoriesResponse response = new CategoriesResponse();
        CategoriesJSONParser jsonUtil = new CategoriesJSONParser();
        String jsonResponse = client.call(createQuery(auth));
        Set<Category> places = jsonUtil.formatResponse(jsonResponse);
        response.setResponse(places);
        return response;
    }

    /**
     * Builds the query for a given lat/lon
     * https://api.hyperpublic.com/api/v1/categories?client_id=8UufhI6bCKQXKMBn7AUWO67Yq6C8RkfD0BGouTke&client_secret=zdoROY5XRN0clIWsEJyKzHedSK4irYee8jpnOXaP
     *
     * @return a String with the URL signed with the ID and SECRET
     */
    private String createQuery(Auth auth) {
        StringBuilder urlBuilder = new StringBuilder();
        return urlBuilder.append(
                Constants.BASE_URL_CATEGORIES_ENDPOINT).
                append("?client_id").append("=").
                append(auth != null && auth.getUserClientID() != null ? auth.getUserClientID() : Auth.DEFAULT_CLIENT_ID).
                append("&client_secret").append("=").
                append(auth != null && auth.getUserClientSecret() != null ? auth.getUserClientSecret() : Auth.DEFAULT_CLIENT_SECRET).toString();
    }

}
