package com.hyperpublic.service;

import com.hyperpublic.domain.Place;
import com.hyperpublic.util.json.PlacesJSONParser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test for th PlacesJSONParse
 * @author @peetersn
 */
public class PlacesJSONParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlacesJSONParserTest.class);

    private static final String jsonResponse = "[{  \"tags\": [  \"Food & Drink\",  \"Food Court\",  \"Restaurant\",  \"mexican\",  \"stand\"  ],  \"phone_number\": null,  \"category\": [  {   \"name\": \"Food\",   \"id\": \"4e28ae8d643bce0004000089\"  }  ],  \"display_name\": \"Calexico Taco / Burrito Cart\",  \"distance\": 0.163579017791097,  \"perma_link\": \"http://hyperpublic.com/places/4e5c0b957038d0000101c2da/profile\",  \"properties\": [  {   \"value\": \"$\",   \"key\": \"price\"  },  {   \"value\": [   \"Clark St (2, 3)\"   ],   \"key\": \"transit\"  },  {   \"value\": \"No\",   \"key\": \"alcohol\"  },  {   \"value\": \"Yes\",   \"key\": \"kids\"  },  {   \"value\": \"No\",   \"key\": \"reservations\"  },  {   \"value\": \"Yes\",   \"key\": \"takeout\"  }  ],  \"locations\": [  {   \"name\": \" Pier 1 Brooklyn Bridge Park, Brooklyn, NY 11201\",   \"lon\": -73.997327,   \"city\": \"Brooklyn\",   \"country\": \"US\",   \"postal_code\": \"11201\",   \"province\": \"NY\",   \"lat\": 40.701219,   \"address_line1\": \" Pier 1 Brooklyn Bridge Park\"  }  ],  \"website\": null,  \"object_type\": \"Place\",  \"id\": \"4e5c0b957038d0000101c2da\",  \"images\": [  {   \"src_thumb\": \"http://hyperpublic.com/images/icons/fooddrink/knifefork/thumb.png\",   \"src_small\": \"http://hyperpublic.com/images/icons/fooddrink/knifefork/small.png\",   \"src_large\": \"http://hyperpublic.com/images/icons/fooddrink/knifefork/square.png\"  }  ] }, {  \"tags\": [  \"Services\",  \"Building & Trades\",  \"Landscaping Services\",  \"Real Estate & Home Improvement\",  \"Landscaping & Gardeners\"  ],  \"phone_number\": \"+1 718 624 1919\",  \"category\": [  {   \"name\": \"Buildings & Workplaces\",   \"id\": \"4e28ae87643bce0004000001\"  },  {   \"name\": \"Offices\",   \"id\": \"4e28ae87643bce0004000014\"  }  ],  \"display_name\": \"Hortus Garden Design\",  \"distance\": 0.21504796814023,  \"perma_link\": \"http://hyperpublic.com/places/4e5d5094c9eea500010162f1/profile\",  \"properties\": [ ],  \"locations\": [  {   \"name\": null,   \"lon\": -73.996243,   \"country\": \"US\",   \"postal_code\": null,   \"lat\": 40.698754,  }  ],  \"website\": null,  \"object_type\": \"Place\",  \"id\": \"4e5d5094c9eea500010162f1\",  \"images\": [  {   \"src_thumb\": \"http://hyperpublic.com/images/icons/public_place/gov/thumb.png\",   \"src_small\": \"http://hyperpublic.com/images/icons/public_place/gov/small.png\",   \"src_large\": \"http://hyperpublic.com/images/icons/public_place/gov/square.png\"  }  ] } ]";

    @Test
    public void decodeJson() {
        PlacesJSONParser jsonUtil = new PlacesJSONParser();
        Set<Place> places = jsonUtil.formatResponse(jsonResponse);
        assertNotNull(places);
        for (Place p : places) {
            LOGGER.info("{}",p);
            assertNull(p.getWebsite());
            assertEquals("Place", p.getObjectType());
            assertNotNull(p.getCategories());
        }
        assertEquals(2, places.size());
    }
}