package com.example.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.UUID;

// Ready to inject into a service. Defaults to calling this API for an offline demo.
@Component
public class OutboundItemClient {
    private static final Logger log = LoggerFactory.getLogger(OutboundItemClient.class);
    private final RestClient client;

    public OutboundItemClient(RestClient outboundRestClient) {
        this.client = outboundRestClient;
    }

    public Item getItem(UUID id) {
        log.info("Fetching item from upstream id={}", id);
        return client.get().uri("/api/items/{id}", id).retrieve().body(Item.class);
    }
}
