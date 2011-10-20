package com.hyperpublic.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author npeeters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String name;
    private Double lat;
    private Double lon;
    @JsonProperty("address_line_1")
    private String addressLine1;
    @JsonProperty("address_line_2")
    private String addressLine2;
    private String city;
    private String province;
    private String country;
    @JsonProperty("postal_code")
    private String postalCode;

    public Location() {
    }

    public Location(String name, Double lat, Double lon, String addressLine1, String addressLine2, String city, String province, String country, String postalCode) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
              b.append(name).append("\",\"").
                append(addressLine1).append("\",\"").
                append(addressLine2).append("\",\"").
                append(city).append("\",\"").
                append(postalCode).append("\",\"").
                append(province).append("\",\"").
                append(country).append("\",\"").
                append(Double.toString(lat)).append("\",\"").
                append(Double.toString(lon));
        return b.toString();
    }
}
