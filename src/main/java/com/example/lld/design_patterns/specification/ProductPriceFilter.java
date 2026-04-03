package com.example.lld.design_patterns.specification;

public class ProductPriceFilter implements Filter<Product> {

    private final int price;

    public ProductPriceFilter(int price) {
        this.price = price;
    }

    @Override
    public boolean isSatisfiedBy(Product other) {
        return other.getPrice() <= price;
    }
}
