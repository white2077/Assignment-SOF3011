import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.repositories.IProductAttributeRepository;
import com.sof3011.assignment.repositories.IProductRepository;
import com.sof3011.assignment.repositories.IProductVariantRepository;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;

public class TestApplication {
    @BeforeAll
    public static void setUpJPA() {
        IProductRepository repository = ContextUtil.getBean(IProductRepository.class);
        Product product = Product.builder().productName("Chuột logitech G102").slug(SlugUtil.convertNameToSlug("Chuột logitech G102")).status(true).thumbnail("21321").build();
        repository.save(product);
    }
    @BeforeAll
    static void testSetup(){
        System.out.println(123);
    }
    @Test
    @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
    @DisplayName("💥💥💥💥💥")
    void assertConvertToSlug() {
        String input = "Chuột logitech G102";
        assertEquals("chuot-logitech-g102", SlugUtil.convertNameToSlug(input));
        System.out.println(SlugUtil.convertNameToSlug(input));
    }
    @Test
    void assertTestAccessProduct(){
        IProductRepository repository = ContextUtil.getBean(IProductRepository.class);
        repository.findAll().forEach(product -> System.out.println(product.getCreatedDate()));
        assertNotNull(repository.findAll());
    }
    @Test
    void testCategory(){
        IProductAttributeRepository repository = ContextUtil.getBean(IProductAttributeRepository.class);
        repository.findById(1L).get()
                .getChildAttributes()
                .forEach(productAttribute -> System.out.println(productAttribute.getChildAttributes()));
    }
}
