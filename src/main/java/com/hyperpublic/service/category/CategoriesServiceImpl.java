package com.hyperpublic.service.category;

import com.hyperpublic.domain.Category;
import com.hyperpublic.domain.Constants;
import com.hyperpublic.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * This is the implementation of the Category endpoint:
 * <p/>
 * http://developer.hyperpublic.com/categories/all-categories/
 *
 * @author @peetersn
 */
public class CategoriesServiceImpl extends AbstractService implements CategoriesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesServiceImpl.class);

    public Category[] getCategories() {
        if (!init) { //this is a bit of hack for SSL trust
            trustSelfSignedSSL();
        }

        RestTemplate restTemplate = createTemplate();
        Category[] res = restTemplate.getForObject(
                        Constants.BASE_URL_CATEGORIES_ENDPOINT + "?client_id={clientId}&client_secret={clientSecret}",
                        Category[].class, Constants.CLIENT_ID, Constants.CLIENT_SECRET);
        return res;
    }
}
