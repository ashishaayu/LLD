package com.example.interview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;
import java.util.Map;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootDemoApplicationTest {
    @Autowired TestRestTemplate http;
    @Autowired RestClient.Builder builder;
    @LocalServerPort int port;

    @Test
    void createsReadsAndFetchesThroughOutboundClient() {
        var response = http.postForEntity("/api/items", new CreateItemRequest("  Example  "), Item.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Item item = response.getBody();
        assertThat(item).isNotNull();
        assertThat(item.name()).isEqualTo("Example");
        assertThat(item.id()).isNotNull();
        assertThat(item.createdAt()).isNotNull();
        assertThat(response.getHeaders().getLocation().toString()).isEqualTo("/api/items/" + item.id());
        assertThat(http.getForObject("/api/items/" + item.id(), Item.class)).isEqualTo(item);

        // Exercise the real configured HTTP client against the local test server.
        var client = new HttpClientConfig().outboundRestClient(builder, "http://localhost:" + port,
                java.time.Duration.ofSeconds(2), java.time.Duration.ofSeconds(5));
        assertThat(new OutboundItemClient(client).getItem(item.id())).isEqualTo(item);
    }

    @Test
    void rejectsInvalidRequestsAndReturnsNotFound() {
        for (var body : new Object[]{Map.of("name", ""), Map.of("name", "   "), Map.of(),
                Map.of("name", "x".repeat(201))}) {
            assertThat(http.postForEntity("/api/items", body, String.class).getStatusCode())
                    .isEqualTo(HttpStatus.BAD_REQUEST);
        }
        assertThat(http.getForEntity("/api/items/" + UUID.randomUUID(), String.class).getStatusCode())
                .isEqualTo(HttpStatus.NOT_FOUND);
    }
}
