package com.hyperpublic.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author npeeters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    @JsonProperty("src_thumb")
    private String thumb;
    @JsonProperty("src_small")
    private String small;
    @JsonProperty("src_large")
    private String large;

    public Image() {
    }

    public Image(String thumb, String small, String large) {
        this.thumb = thumb;
        this.small = small;
        this.large = large;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
