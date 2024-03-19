package com.sof3011.assignment.utils;

import jakarta.validation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorUtils {
    public static <T> Map<String,String> validate(T object) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        return violations.stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage
                ));
    }
}
