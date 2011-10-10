package com.hyperpublic.service.category;

import com.hyperpublic.domain.Category;

import java.util.Set;

/**
 * Value object that contains all the categories.
 * 
 * @author @peetersn
 */
public class CategoriesResponse {

    private Set<Category> response;

    public Set<Category> getResponse() {
        return response;
    }

    public void setResponse(Set<Category> response) {
        this.response = response;
    }
}
