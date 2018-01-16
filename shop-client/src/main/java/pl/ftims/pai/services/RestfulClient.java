package pl.ftims.pai.services;

import org.springframework.web.client.RestTemplate;

/**
 * Created by Alebazi on 2018-01-07.
 */
public class RestfulClient {
    RestTemplate restTemplate;

    public RestfulClient() {
        restTemplate = new RestTemplate();
    }
}
