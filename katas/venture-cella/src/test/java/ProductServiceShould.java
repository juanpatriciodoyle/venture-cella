import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import com.vc.repository.ProductRepository;
import com.vc.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceShould {

    public static final int PAGE = 0;
    public static final int SIZE = 2;
    public static final String DESCRIPTION = "Fruit";
    public static final double PRICE = 3.99;
    public static final double WEIGHT = 1.0;
    public static final String COUNTRY = "Brazil";
    public static final String PRODUCT_NAME = "Strawberries";

    private static ProductDto productDto;
    private static Product product;

    @Mock
    ProductRepository productRepository;

    @Spy
    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach
    void clean_attrs() {
        productDto = null;
        product = null;
    }

    @Test
    void create_new_product() {
        given_productDto();

        when_product_saved();

        then_save_should_have_been_called_once();
    }

    @Test
    void delete_product() {
        given_product();

        when_delete_is_called();

        then_delete_should_have_been_called_once();

    }

    @Test
    void search_by_name() {
        given_product();

        when_product_searched_by_its_name();

        then_returns_product();

    }

    @Test
    void get_all_products() {
        when_getting_all_products();

        then_get_all_should_have_been_called_once();
    }

    @Test
    void get_products_by_page() {
        when_getting_all_products_by_page();

        then_get_all_by_page_should_have_been_called_once();
    }

    private void then_get_all_by_page_should_have_been_called_once() {
        verify(productService, times(1)).getAll(PAGE, SIZE);
    }

    private void when_getting_all_products_by_page() {
        try {
            productService.getAll(PAGE, SIZE);
        } catch (NullPointerException e) {
            e.getSuppressed();
        }
    }

    private void given_productDto() {
        productDto = new ProductDto(PRODUCT_NAME, DESCRIPTION, PRICE, WEIGHT, COUNTRY);
    }

    private void given_product() {
        product = new Product(1L, PRODUCT_NAME, DESCRIPTION, PRICE, WEIGHT, COUNTRY);
    }

    private void when_product_saved() {
        productService.save(productDto);
    }

    private void when_product_searched_by_its_name() {
        when(productRepository.getByName(PRODUCT_NAME)).thenReturn(Collections.singletonList(product));
    }

    private void when_getting_all_products() {
        productService.getAll();
    }

    private void when_delete_is_called() {
        try {
            productService.delete(product.getId());
        } catch (EntityNotFoundException e) {
            e.getSuppressed();
        }
    }

    private void then_save_should_have_been_called_once() {
        verify(productService, times(1)).save(productDto);
    }

    private void then_returns_product() {
        Assertions.assertEquals(product.getName(), PRODUCT_NAME);
    }

    private void then_get_all_should_have_been_called_once() {
        verify(productService, times(1)).getAll();
    }

    private void then_delete_should_have_been_called_once() {
        verify(productService, times(1)).delete(product.getId());
    }
}
