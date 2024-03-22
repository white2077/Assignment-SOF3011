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
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ContextUtil.getBean(JpaConfig.class);
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
