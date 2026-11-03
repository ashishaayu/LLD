package com.example.interview;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExotelClient {

    private  final RestClient restClient;

    public ExotelClient(RestClient.Builder builder,
                        @Value("${exotel.base-url}") String baseUrl) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public  ExtoelResponse makeCall(String phoneNumber,
                                    String message) {

        return  restClient
                .post()
                .uri("v1/calls")
                .body(new ExtoelRequest(phoneNumber,message))
                .retrieve()
                .body(ExtoelResponse.class);
    }

}
