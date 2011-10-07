package com.hyperpublic.domain;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Category object
 * @author @peetersn
 */
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

    @Override
    public String toString() {
        return getName();
    }
}
