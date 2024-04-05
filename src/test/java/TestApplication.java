import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.repositories.*;
import com.sof3011.assignment.services.IOrderDetailService;
import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.OrderDetailService;
import com.sof3011.assignment.services.impl.UserService;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;

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
    void testCart() {
        IOrderDetailRepository iOrderDetailRepository = ContextUtil.getBean(IOrderDetailRepository.class);
        iOrderDetailRepository.findById(25L).get().getOrderItems().forEach(orderItem -> {
            System.out.println(orderItem.getProductVariant().getProduct().getProductName());
        });
    }

    @Test
    void testOrder() {
        IOrderDetailService iOrderDetailService = ContextUtil.getBean(OrderDetailService.class);
        IUserService iUserService = ContextUtil.getBean(UserService.class);
        iOrderDetailService.getbyCustomer(iUserService.getUserByUsername("yu")).forEach(orderDetail -> {
            System.out.println(orderDetail.getCustomerName());
        });
        iUserService.getUserByUsername("yu").getAddresses().forEach(address -> {
            System.out.println(address.getAddress());
        });
    }
}
