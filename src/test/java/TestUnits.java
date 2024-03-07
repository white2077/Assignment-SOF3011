import com.sof3011.assignment.config.JpaConfig;
import com.sof3011.assignment.repositories.IUserRepository;
import com.sof3011.assignment.utils.ContextUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUnits {
    @Test
    public void name() {
        ContextUtils.getBean(IUserRepository.class).findAll();
    }
}
