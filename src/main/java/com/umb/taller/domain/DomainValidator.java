package com.umb.taller.domain;

@FunctionalInterface
public interface DomainValidator<T> {

    boolean validate(T value);
}
