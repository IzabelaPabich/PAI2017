package pl.ftims.pai.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.ftims.pai.client.OrderClient;
import pl.ftims.pai.client.ProductClient;
import pl.ftims.pai.dto.NewOrderData;
import pl.ftims.pai.dto.NewOrderForm;
import pl.ftims.pai.entities.Order;
import pl.ftims.pai.entities.Product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alebazi on 2018-01-15.
 */
@Controller
public class OrderController {

    @Autowired
    ProductClient productClient;

    @Autowired
    OrderClient orderClient;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/order")
    public String getOrder(Model model) {
        List<Product> productList = Arrays.asList(productClient.getProducts());
        model.addAttribute("products", productList);
        return "new_order";
    }

    @GetMapping("/new_order")
    public String newOrder(Model model) {
        List<Product> productList = Arrays.asList(productClient.getProducts());
        model.addAttribute("products", productList);
        return "new_order";
    }

    @PostMapping("/new_order")
    public String saveOrder(@ModelAttribute(name = "newOrderForm") NewOrderForm newOrderForm, Model model) throws JSONException, IOException {

        NewOrderData newOrder = new NewOrderData();
        newOrder.setQuantity(newOrderForm.getQuantity());
        String[] parts = newOrderForm.getName().split("\\,");
        newOrder.setProductId(Long.parseLong(parts[0]));

        Order returnedOrder = orderClient.postNewOrder(newOrder);

        model.addAttribute("newOrder", returnedOrder);
        return "new_order";
    }

}
