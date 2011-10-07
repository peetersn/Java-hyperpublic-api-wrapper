package com.hyperpublic.service;

import com.hyperpublic.domain.Category;
import com.hyperpublic.util.json.CategoriesJSONParser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author @peetersn
 */
public class CategoriesJSONParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesJSONParserTest.class);

    @Test
    public void decode() {
        CategoriesJSONParser jsonUtil = new CategoriesJSONParser();
        String jsonResponse = "[ { \"id\" : \"4e24708ae0a787070b000001\",  \"name\" : \"Buildings & Workplaces\",  \"subcategories\" : " +
                "[ { \"id\" : \"4e24708be0a787070b000003\",   \"name\" : \"Auditoriums\",   \"subcategories\" : [ ]   },   " +
                "{ \"id\" : \"4e24708be0a787070b000010\",   \"name\" : \"Gyms\",   \"subcategories\" : [ { \"id\" : \"4e24708be0a787070b000011\",     " +
                "\"name\" : \"Tracks\",     \"subcategories\" : [ ]    } ]   },   { \"id\" : \"4e24708be0a787070b00001d\",   \"name\" : \"Parking Garages\",   " +
                "\"subcategories\" : [ ]   },   { \"id\" : \"4e24708be0a787070b000025\",   \"name\" : \"Real Estate\",   \"subcategories\" : [ " +
                "{ \"id\" : \"4e24708be0a787070b000026\",     \"name\" : \"Real Estate Agent\",     \"subcategories\" : [ ]    },    " +
                "{ \"id\" : \"4e24708be0a787070b000027\",     \"name\" : \"Real Estate Operator\",     \"subcategories\" : [ ]    },    " +
                "{ \"id\" : \"4e24708be0a787070b000028\",     \"name\" : \"Real Estate Services\",     \"subcategories\" : [ ]    }    ]   },   " +
                "{ \"id\" : \"4e24708be0a787070b00001e\",   \"name\" : \"Religious Centers\",   \"subcategories\" : [ { \"id\" : \"4e24708be0a787070b000021\", " +
                "    \"name\" : \"Churches\",     \"subcategories\" : [ ]    },    { \"id\" : \"4e24708be0a787070b000022\",     \"name\" : \"Mosques\",    " +
                " \"subcategories\" : [ ]    },    { \"id\" : \"4e24708be0a787070b00001f\",     \"name\" : \"Synagogues\",     \"subcategories\" : [ ]    }, " +
                "   { \"id\" : \"4e24708be0a787070b000020\",     \"name\" : \"Temples\",     \"subcategories\" : [ ]    }    ]   },   " +
                "{ \"id\" : \"4e24708be0a787070b000029\",   \"name\" : \"Social Services\",   \"subcategories\" : [ { \"id\" : \"4e24708be0a787070b00002a\",   " +
                "  \"name\" : \"Child Care\",     \"subcategories\" : [ ]    } ]   },   { \"id\" : \"4e24708be0a787070b00002b\",  " +
                " \"name\" : \"Television Station\",   \"subcategories\" : [ ]   },   { \"id\" : \"4e24708ce0a787070b00002d\",   \"name\" " +
                ": \"Veterinary Services\",   \"subcategories\" : [ ]   },   { \"id\" : \"4e24708be0a787070b000023\",   \"name\" : \"Yoga Studios\",   " +
                "\"subcategories\" : [ ]   }  ] }, { \"id\" : \"4e2470a3e0a787070b000152\",  \"name\" : \"Travel\",  \"subcategories\" :" +
                " [ { \"id\" : \"4e2470a3e0a787070b000153\",   \"name\" : \"Airports\",   \"subcategories\" : [ { \"id\" : \"4e2470a3e0a787070b000154\",   " +
                "  \"name\" : \"Airport Food Court\",     \"subcategories\" : [ ]    },    { \"id\" : \"4e2470a3e0a787070b000157\",    " +
                " \"name\" : \"Airport Gates\",     \"subcategories\" : [ ]    },    { \"id\" : \"4e2470a3e0a787070b000156\",     \"name\" :" +
                " \"Airport Rental Car Spots\",     \"subcategories\" : [ ]    },    { \"id\" : \"4e2470a3e0a787070b000155\",     \"name\" :" +
                " \"Airport Terminals\",     \"subcategories\" : [ ]    }    ]   },   { \"id\" : \"4e2470a4e0a787070b000158\",   \"name\" : " +
                "\"Bed & Breakfasts\",   \"subcategories\" : [ ]   },   { \"id\" : \"4e2470a5e0a787070b000163\",   \"name\" : \"Train Station\",  " +
                " \"subcategories\" : [ ]   },   { \"id\" : \"4e2470a5e0a787070b000164\",   \"name\" : \"Travel Destination\",   \"subcategories\" : [ ]   }  ] } ]";
        Set<Category> categories = jsonUtil.formatResponse(jsonResponse);
        assertNotNull(categories);
        assertEquals(2, categories.size());
        for (Category c : categories) {
            LOGGER.info("{}", c);
            assertNotNull(c.getId());
            assertNotNull(c.getName());
            assertNotNull(c.getSubCategories());
        }
    }
}
