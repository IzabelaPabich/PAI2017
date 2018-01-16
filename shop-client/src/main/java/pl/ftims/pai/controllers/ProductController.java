package pl.ftims.pai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.ftims.pai.client.ProductClient;
import pl.ftims.pai.entities.Product;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alebazi on 2018-01-15.
 */
@Controller
public class ProductController {

    @Autowired
    ProductClient productClient;

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> productList = Arrays.asList(productClient.getProducts());
        System.out.println(productList.get(1).getColor());
        model.addAttribute("products", productList);
        return "products";
    }
}
