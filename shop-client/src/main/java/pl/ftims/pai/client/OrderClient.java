package pl.ftims.pai.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.ftims.pai.dto.NewOrderData;
import pl.ftims.pai.entities.Order;
import pl.ftims.pai.entities.Product;

import java.io.DataInput;
import java.io.IOException;

/**
 * Created by Alebazi on 2018-01-16.
 */
@Component
public class OrderClient {

    private final String url;

    RestTemplate restTemplate;

    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public OrderClient(@Value("${neworder.service.url}") final String url) {
        this.url = url;
    }

    public Order postNewOrder(NewOrderData newOrderData) throws IOException, JSONException {

        JSONObject userJson = new JSONObject();
        String requestJson = mapper.writeValueAsString(newOrderData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity(requestJson,headers);

        restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        System.out.println(response.toString());

        if (response.getStatusCode() == HttpStatus.CREATED) {
             userJson = new JSONObject(response.getBody());

        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            //userJson pusty
        }
        return mapper.readValue(userJson.toString(), Order.class);
    }
}
