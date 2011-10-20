package com.hyperpublic.service.category;

import com.hyperpublic.domain.Category;

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
     * @return a response object containing the array of categories
     */
    Category[] getCategories();
}
