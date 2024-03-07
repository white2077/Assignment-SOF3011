import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.repositories.ICustomerRepository;
import com.sof3011.assignment.repositories.IProductRepository;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnits {
    @Test
    public void testBootSpringData() {
        IProductRepository repository = ContextUtil.getBean(IProductRepository.class);
        Product product = Product.builder().productName("Chuột logitech G102").slug(SlugUtil.convertNameToSlug("Chuột logitech G102")).status(true).build();
        product.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        repository.save(product);
    }

    @Test
    void assertConvertToSlug() {
        String input = "Chuột logitech G102";
        assertEquals("chuot-logitech-g102", SlugUtil.convertNameToSlug(input));
        System.out.println(SlugUtil.convertNameToSlug(input));
    }
}
