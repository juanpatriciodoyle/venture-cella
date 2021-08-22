import com.vc.model.dto.ProductDto;
import com.vc.repository.ProductRepository;
import com.vc.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceShould {

    @Mock
    ProductRepository productRepository;

    @Spy
    @InjectMocks
    ProductServiceImpl productService;

    ProductDto productDto;

    String PRODUCT_NAME = "Strawberries";

    @BeforeEach
    void clean_attrs() {
        productDto = null;
    }

    @Test
    void create_new_product() {
        given_productDto();

        when_product_saved();

        then_save_should_be_called_once();
    }

    private void then_save_should_be_called_once() {
        verify(productService, times(1)).save(productDto);
    }

    private void when_product_saved() {
        productService.save(productDto);
    }

    private void given_productDto() {
        productDto = new ProductDto(PRODUCT_NAME, "Fruit", 3.99, 1.0, "Brazil");
    }
}
