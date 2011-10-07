package com.hyperpublic.service.category;

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
     * @return
     */
    CategoriesResponse callEndpoint();
}
