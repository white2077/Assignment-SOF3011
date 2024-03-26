import com.sof3011.assignment.repositories.IProductAttributeRepository;
import com.sof3011.assignment.repositories.IProductRepository;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestApplication {
    @Test
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
        repository.findAllSlugForProductAttributeAndProductVariant(false).forEach(System.out::println);
    }
    @Test
    void testSlug(){
        IProductRepository repository = ContextUtil.getBean(IProductRepository.class);
        repository.findTop8ByStatusIsTrueOrderByCreatedDateDesc().forEach(product -> System.out.println(product.getSlug()));
    }

    @Test
    void testGetMinMaxPrice() {
        IProductRepository productRepository = ContextUtil.getBean(IProductRepository.class);
        productRepository.findBySlug("laptop-ganyu-sieu-chat-luong").orElse(null).getMinMaxPrices().forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
    @Test
    void testCallApi() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8080/add-to-cart");
            CloseableHttpResponse response = httpClient.execute(httpGet);

            // Lấy nội dung JSON từ phản hồi
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
