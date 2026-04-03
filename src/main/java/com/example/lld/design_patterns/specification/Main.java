package com.example.lld.design_patterns.specification;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.addAll(
                List.of(
                        new Product("macbook", 150),
                        new Product("mouse", 50),
                        new Product("laptop", 500),
                        new Product("pendrive", 99),
                        new Product("mibook", 88)
                )
        );

        Filter<Product> nameFilter = new ProductNameFilter("m");
        Filter<Product> priceFilter = new ProductPriceFilter(200);

        Filter<Product> nameAndPriceFilter = nameFilter.and(priceFilter).or(new ProductNameFilter("l"));

        List<Product> list = productList.stream().filter(nameAndPriceFilter::isSatisfiedBy).toList();
        System.out.println(list);

    }
}
