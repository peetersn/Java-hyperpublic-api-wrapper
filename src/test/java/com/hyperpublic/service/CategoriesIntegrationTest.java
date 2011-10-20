package com.hyperpublic.service;

import com.hyperpublic.domain.Category;
import com.hyperpublic.service.category.CategoriesService;
import com.hyperpublic.service.category.CategoriesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * This is an integration test of the service
 * @author @peetersn
 */
public class CategoriesIntegrationTest {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoriesIntegrationTest.class);

    private CategoriesService categoriesService;

    @Before
    public void before(){
        categoriesService = new CategoriesServiceImpl();
    }
    
    @Test
    public void simpleCall() {
        Category[] categories = categoriesService.getCategories();
        assertNotNull(categories);
        assertTrue(categories.length > 5);
        for (Category c : categories) {
            LOGGER.info("{}", c);
        }
    }
}
