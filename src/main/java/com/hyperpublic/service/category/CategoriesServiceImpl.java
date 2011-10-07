package com.hyperpublic.service.category;

import com.hyperpublic.domain.Category;
import com.hyperpublic.domain.Constants;
import com.hyperpublic.service.AbstractService;
import com.hyperpublic.util.http.GenericHttpsClient;
import com.hyperpublic.util.json.CategoriesJSONParser;

import java.util.Set;

/**
 * This is the implementation of the Category endpoint:
 *
 * http://developer.hyperpublic.com/categories/all-categories/
 *
 * @author @peetersn
 */
public class CategoriesServiceImpl extends AbstractService implements CategoriesService  {

    private final GenericHttpsClient client = new GenericHttpsClient();

    @Override
    public CategoriesResponse callEndpoint() {
        CategoriesResponse response = new CategoriesResponse();
        CategoriesJSONParser jsonUtil = new CategoriesJSONParser();
        String jsonResponse = client.call(createQuery());
        Set<Category> places = jsonUtil.formatResponse(jsonResponse);
        response.setResponse(places);
        return response;
    }

    /**
     * Builds the query for a given lat/lon
     * https://api.hyperpublic.com/api/v1/categories?client_id=8UufhI6bCKQXKMBn7AUWO67Yq6C8RkfD0BGouTke&client_secret=zdoROY5XRN0clIWsEJyKzHedSK4irYee8jpnOXaP
     * @return a String with the URL signed with the ID and SECRET
     */
    private String createQuery() {
        StringBuilder urlBuilder = new StringBuilder();
        return urlBuilder.append(
                Constants.BASE_URL_CATEGORIES_ENDPOINT).
                append("?client_id").append("=").append(Constants.CLIENT_ID).
                append("&client_secret").append("=").append(Constants.CLIENT_SECRET).toString();
    }

}
