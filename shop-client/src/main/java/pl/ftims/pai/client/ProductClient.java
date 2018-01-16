package pl.ftims.pai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.ftims.pai.entities.Product;

/**
 * Created by Alebazi on 2018-01-14.
// */
@Component
public class ProductClient {

    private final String url;

    RestTemplate restTemplate;


    @Autowired
    public  ProductClient(@Value("${product.service.url}") final String url) {
        this.url = url;
    }

    public Product[] getProducts() {
        restTemplate = new RestTemplate();
        Product[] products;
        products = restTemplate.getForObject(url, Product[].class);
        return products;
    }
}
