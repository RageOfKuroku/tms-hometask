package com.example.feignsecond.config;

import com.example.feignsecond.exception.FailedTaskException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
@RequiredArgsConstructor
@Configuration
public class FeignConfig {

    private final ObjectMapper mapper;
    @Bean
    public ErrorDecoder decoder() {
        return (methodKey, response) -> {
            int status = response.status();

            if (status > 400 && status < 500) {
                Response.Body body = response.body();
                InputStream inputStream = null;
                try {
                    return mapper.readValue(body.asInputStream(), FailedTaskException.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
            return null;
        };
    }
}