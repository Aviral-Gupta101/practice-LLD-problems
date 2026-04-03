package com.example.lld.design_patterns.specification;

public class ProductNameFilter implements Filter<Product> {

    private final String name;

    public ProductNameFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(Product other) {
        return name.equalsIgnoreCase(other.getName()) || other.getName().toLowerCase().startsWith(name.toLowerCase());
    }
}
