import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {

    @Test
    void testUseCase(){
        Assertions.assertNotNull(new Category());
        Assertions.assertNotNull(new UseCase().execute());
    }
}
