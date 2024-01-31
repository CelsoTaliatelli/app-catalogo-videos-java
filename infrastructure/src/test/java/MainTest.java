import com.cht.admin.catalogo.infrastructure.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testMain(){
        Assertions.assertNotNull(new Main());
        Main.main(new String[]{});
    }
}
