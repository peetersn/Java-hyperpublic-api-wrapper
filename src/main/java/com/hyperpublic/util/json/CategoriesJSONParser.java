package com.hyperpublic.util.json;

import com.hyperpublic.domain.Category;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Parses the response of the category endpoint into a Category Java object.
 *
 * @author @peetersn
 */
public class CategoriesJSONParser {

    public Set<Category> formatResponse(String jsonString) {

        Set<Category> categories = new LinkedHashSet<Category>();
        if (StringUtils.isNotBlank(jsonString)) {
            for (Object element : JSONArray.fromObject(jsonString)) {
                Category mainCat = createCat((JSONObject) element);
                categories.add(mainCat);
            }
        }
        return categories;
    }

    /**
     * Helper to create a category based on a JSON object
     *
     * @param json JSON object
     * @return a category (with its subcategories)
     */
    private Category createCat(JSONObject json) {
        Category c = new Category(json.getString("id"), json.getString("name"));
        addSubCategories(json, c);
        return c;
    }

    /**
     * Recursively add subCategories.
     * @param json object
     * @param c Category
     */
    private void addSubCategories(JSONObject json, Category c) {
        String SUBCATEGORIES = "subcategories";
        JSONArray subCatArray = (JSONArray) json.opt(SUBCATEGORIES);

        if (subCatArray != null) {
            for (Object subCat : subCatArray) {
                Category subCategory = createCat((JSONObject) subCat);
                c.addCategories(subCategory);
            }
        }
    }
}

