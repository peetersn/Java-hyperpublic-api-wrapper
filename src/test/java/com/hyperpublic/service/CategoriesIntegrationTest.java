package com.hyperpublic.service;

import com.hyperpublic.service.category.CategoriesResponse;
import com.hyperpublic.service.category.CategoriesService;
import com.hyperpublic.service.category.CategoriesServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * This is an integration test of the service
 * @author @peetersn
 */
public class CategoriesIntegrationTest {

    private CategoriesService categoriesService;

    @Before
    public void before(){
        categoriesService = new CategoriesServiceImpl();
    }
    
    @Test
    public void simpleCall() {
        CategoriesResponse res = categoriesService.callEndpoint();
        assertNotNull(res);
        assertNotNull(res.getResponse());
        assertTrue(res.getResponse().size() > 5);
    }
}
