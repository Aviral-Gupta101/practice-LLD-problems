package com.example.lld.design_patterns.specification;

public interface Filter<T> {

    boolean isSatisfiedBy(T t);

    default Filter<T> or(Filter<T> other){

        return item -> this.isSatisfiedBy(item) || other.isSatisfiedBy(item);
    }

    default Filter<T> and(Filter<T> other){

        return item -> this.isSatisfiedBy(item) && other.isSatisfiedBy(item);
    }
}
