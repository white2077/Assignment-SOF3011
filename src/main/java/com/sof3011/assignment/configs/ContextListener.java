package com.sof3011.assignment.configs;

import com.sof3011.assignment.entities.ProductAttribute;
import com.sof3011.assignment.repositories.IProductAttributeRepository;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class ContextListener implements ServletContextListener {
    private AnnotationConfigApplicationContext applicationContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        applicationContext = new AnnotationConfigApplicationContext(JpaConfig.class);
        System.out.println("Spring data active status: " + applicationContext.isActive());
//        ContextUtil.getBean(IProductAttributeRepository.class)
//                .save(ProductAttribute
//                        .builder()
//                        .attributeName("Category")
//                        .slug(SlugUtil.convertNameToSlug("category"))
//                        .childAttributes(Set.of(ProductAttribute.builder().build()))
//                        .attributeType(null)
//                        .build());
    }
}
