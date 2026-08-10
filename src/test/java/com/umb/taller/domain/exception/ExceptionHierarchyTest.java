package com.umb.taller.domain.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExceptionHierarchyTest {

    @Test
    void shouldMaintainExceptionHierarchy() {

        EntityNotFoundException exception =
                new EntityNotFoundException("Usuario no encontrado");

        assertThat(exception)
                .isInstanceOf(EntityNotFoundException.class)
                .isInstanceOf(DomainException.class)
                .isInstanceOf(AppException.class)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldCreateValidationException() {

        ValidationException exception =
                new ValidationException("El correo no es válido");

        assertThat(exception.getMessage())
                .isEqualTo("El correo no es válido");

        assertThat(exception)
                .isInstanceOf(DomainException.class)
                .isInstanceOf(AppException.class);
    }

    @Test
    void shouldCreateBusinessRuleException() {

        BusinessRuleException exception =
                new BusinessRuleException("No se puede realizar la operación");

        assertThat(exception.getMessage())
                .isEqualTo("No se puede realizar la operación");

        assertThat(exception)
                .isInstanceOf(DomainException.class)
                .isInstanceOf(AppException.class);
    }

    @Test
    void shouldPreserveExceptionMessage() {

        String message = "Libro no encontrado";

        EntityNotFoundException exception =
                new EntityNotFoundException(message);

        assertThat(exception)
                .hasMessage(message);
    }

    @Test
    void shouldCreateDifferentDomainExceptions() {

        EntityNotFoundException notFound =
                new EntityNotFoundException("Usuario no encontrado");

        ValidationException validation =
                new ValidationException("Datos inválidos");

        BusinessRuleException business =
                new BusinessRuleException("Regla de negocio incumplida");

        assertThat(notFound).isInstanceOf(DomainException.class);
        assertThat(validation).isInstanceOf(DomainException.class);
        assertThat(business).isInstanceOf(DomainException.class);

        assertThat(notFound.getMessage())
                .isNotEqualTo(validation.getMessage());
    }
}