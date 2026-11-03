package com.example.interview;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpClientConfig {
    @Bean
    RestClient outboundRestClient(RestClient.Builder builder,
            @Value("${outbound.base-url}") String baseUrl,
            @Value("${outbound.connect-timeout}") Duration connectTimeout,
            @Value("${outbound.read-timeout}") Duration readTimeout) {
        HttpClient client = HttpClient.newBuilder().connectTimeout(connectTimeout).build();
        JdkClientHttpRequestFactory factory = new JdkClientHttpRequestFactory(client);
        factory.setReadTimeout(readTimeout);
        return builder.baseUrl(baseUrl).requestFactory(factory).build();
    }
}
