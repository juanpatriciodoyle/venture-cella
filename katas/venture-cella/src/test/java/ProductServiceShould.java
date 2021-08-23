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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceShould {

    @Mock
    ProductRepository productRepository;

    @Spy
    @InjectMocks
    ProductServiceImpl productService;

    ProductDto productDto;
    Product product;
    List<Product> productList;

    String PRODUCT_NAME = "Strawberries";

    @BeforeEach
    void clean_attrs() {
        productDto = null;
        product = null;
        productList = new ArrayList<>();
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
        given_product_list();

        when_getting_all_products();

        then_get_all_should_have_been_called_once();
    }

    private void given_productDto() {
        productDto = new ProductDto(PRODUCT_NAME, "Fruit", 3.99, 1.0, "Brazil");
    }

    private void given_product() {
        product = new Product(1L, PRODUCT_NAME, "Fruit", 3.99, 1.0, "Brazil");
    }

    private void given_product_list() {
        int i = 3;
        while (i > 0) {
            product = new Product(1L, PRODUCT_NAME, "Fruit " + i, 3.99, 1.0, "Brazil");
            productList.add(product);
            i--;
        }

    }

    private void when_product_saved() {
        productService.save(productDto);
    }

    private void when_product_searched_by_its_name() {
        when(productRepository.getByName(PRODUCT_NAME)).thenReturn(Collections.singletonList(product));
    }

    private void when_getting_all_products() {
        productService.getAll(0, 0);
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
        verify(productService, times(1)).getAll(0, 0);
    }

    private void then_delete_should_have_been_called_once() {
        verify(productService, times(1)).delete(product.getId());
    }
}
