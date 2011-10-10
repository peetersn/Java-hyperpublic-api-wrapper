package com.hyperpublic.service.category;

import com.hyperpublic.domain.Auth;

/**
 * This implements the Category endpoint:
 *
 * http://developer.hyperpublic.com/categories/all-categories/
 *
 * @author @peetersn
 */
public interface CategoriesService {

    /**
     * Returns the list of categories
     * @param auth contains the authorization tokens
     * @return a response object containing the list of categories
     */
    CategoriesResponse callEndpoint(Auth auth);
}
