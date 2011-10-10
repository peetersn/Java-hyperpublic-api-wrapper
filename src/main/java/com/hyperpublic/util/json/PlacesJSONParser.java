package com.hyperpublic.util.json;

import com.hyperpublic.domain.Category;
import com.hyperpublic.domain.Image;
import com.hyperpublic.domain.Location;
import com.hyperpublic.domain.Place;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Transforms the JSON into Java objects
 * @author @peetersn
 */
public class PlacesJSONParser {

    /** Transforms the JSON response into a Java object.
     * //TODO I'm sure there's a easier way to do this. This is future work!
     *
     * @param jsonString the raw JSON string.
     * @return a Set of Place objects
     */
    public Set<Place> formatResponse(String jsonString) {

        Set<Place> places = new LinkedHashSet<Place>();
        if (StringUtils.isNotBlank(jsonString)) {
            JSONArray jsonArray = JSONArray.fromObject(jsonString);

            for (Object element : jsonArray) {
                JSONObject json = (JSONObject) element;
                Place place = new Place();
                place.setId(json.getString("id"));
                place.setDisplayName(json.getString("display_name"));
                place.setPhoneNumber(json.optString("phone_number"));
                place.setDistance(json.optDouble("distance"));
                if (!json.optString("website").equals("null")) {
                    place.setWebsite(json.optString("website"));
                }
                place.setPermaLink(json.optString("perma_link"));
                place.setObjectType(json.getString("object_type"));

                for (Object loc : (JSONArray) json.get("locations")) {
                    JSONObject l = (JSONObject) loc;
                    place.addLocations(new Location(
                            l.optString("name"),
                            l.optDouble("lat"),
                            l.optDouble("lon"),
                            l.optString("address_line1"),
                            l.optString("address_line2"),
                            l.optString("city"),
                            l.optString("province"),
                            l.optString("country"),
                            l.optString("postal_code")
                    ));
                }

                for (Object tag : (JSONArray) json.get("tags")) {
                    place.addTag((String) tag);
                }
                for (Object cat : (JSONArray) json.get("category")) {
                    JSONObject o = (JSONObject) cat;
                    place.addCategory(new Category(o.optString("id"), o.optString("name")));
                }
                for (Object img : (JSONArray) json.get("images")) {
                    JSONObject o = (JSONObject) img;
                    place.addImage(new Image(o.optString("src_thumb"), o.optString("src_small"), o.optString("src_large")));
                }
                for (Object p : (JSONArray) json.get("properties")) {
                    place.addProperty(((JSONObject) p).optString("key"), ((JSONObject) p).optString("value"));
                }

                places.add(place);
            }
        }
        return places;
    }
}

