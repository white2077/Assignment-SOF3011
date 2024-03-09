package com.sof3011.assignment.utils;

import jakarta.validation.*;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

import java.util.Set;

public class ValidatorUtils {
    public static <T> Set<ConstraintViolation<T>> validate(T object) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(object);
    }
}
