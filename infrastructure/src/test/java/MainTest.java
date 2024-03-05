import com.cht.admin.catalogo.infrastructure.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.AbstractEnvironment;

import static org.springframework.core.env.AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME;

public class MainTest {

    @Test
    void testMain(){
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
        Assertions.assertNotNull(new Main());
        Main.main(new String[]{});
    }
}
