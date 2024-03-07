import com.sof3011.assignment.repositories.IUserRepository;
import com.sof3011.assignment.utils.ContextUtils;
import org.junit.jupiter.api.Test;

public class TestUnits {
    @Test
    public void testBootSpringData() {
        ContextUtils.getBean(IUserRepository.class).findAll();
    }
}
