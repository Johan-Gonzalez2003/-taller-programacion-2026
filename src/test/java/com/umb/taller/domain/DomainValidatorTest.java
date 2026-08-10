package com.umb.taller.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DomainValidatorTest {

    @Test
    void shouldValidateUsingFirstLambda() {
        DomainValidator<String> validator =
                value -> value != null;

        assertTrue(validator.validate("Johan"));
    }

    @Test
    void shouldValidateUsingSecondLambda() {
        DomainValidator<String> validator =
                value -> value.length() >= 5;

        assertTrue(validator.validate("Johan"));
    }

    @Test
    void shouldValidateUsingThirdLambda() {
        DomainValidator<Integer> validator =
                value -> value > 18;

        assertTrue(validator.validate(20));
    }

    @Test
    void shouldValidateUsingMethodReference() {
        DomainValidator<String> validator =
                UserValidations::isNotEmpty;

        assertTrue(validator.validate("Usuario"));
        assertFalse(validator.validate(""));
    }
}