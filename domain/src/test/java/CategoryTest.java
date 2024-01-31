import com.cht.admin.catalogo.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    void testNewCategory(){
        Assertions.assertNotNull(new Category());
    }
}
