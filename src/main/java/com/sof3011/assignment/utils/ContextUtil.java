package com.sof3011.assignment.utils;

import com.sof3011.assignment.configs.JpaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextUtil {
    private static final AnnotationConfigApplicationContext context;

    static {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
