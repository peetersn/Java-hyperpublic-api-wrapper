package com.hyperpublic.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author npeeters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    private String id;
    private String name;
    private Set<Category> subCategories = new LinkedHashSet<Category>();

    public Category() {
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public void addCategories(Category cat) {
        getSubCategories().add(cat);
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getName()).append("#");
        for (Category subCategory : subCategories) {
            b.append(subCategory.getName()).append("#");

            if (subCategory.getSubCategories() != null) {
                for (Category subsub : subCategory.getSubCategories()) {
                    b.append(subsub.getName()).append("#");
                }
            }
        }
        return getName();

    }
}
