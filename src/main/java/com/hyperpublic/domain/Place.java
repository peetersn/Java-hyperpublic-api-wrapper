package com.hyperpublic.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author npeeters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

    private String id;
    @JsonProperty("object_type")
    private String objectType;
    @JsonProperty("perma_link")
    private String permaLink;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String website;

    private Double distance;
    private List<Location> locations = new ArrayList<Location>();

    @JsonProperty("images")
    private List<Image> images = new ArrayList<Image>();
    @JsonProperty("tags")
    private List<String> tags = new ArrayList<String>();

    @JsonProperty("category")
    private List<Category> categories = new ArrayList<Category>();

//    @JsonProperty("properties")
//    private List<Property> properties = new ArrayList<Property>();
//    TODO there's an issue with some of the properties so I exclude them explicitely from the mapping...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getPermaLink() {
        return permaLink;
    }

    public void setPermaLink(String permaLink) {
        this.permaLink = permaLink;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void addLocations(Location location) {
        this.getLocations().add(location);
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        getTags().add(tag);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        getCategories().add(category);
    }

//    public List<Property> getProperties() {
//        return properties;
//    }
//
//    public void setProperties(List<Property> properties) {
//        this.properties = properties;
//    }
//
//    public void addProperty(String key, String value) {
//        String [] v = { value };
//        getProperties().add(new Property(key, v));
//    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }


}

