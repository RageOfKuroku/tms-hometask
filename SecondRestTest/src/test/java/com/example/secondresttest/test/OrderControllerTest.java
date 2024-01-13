package com.example.secondresttest.test;

import com.example.secondresttest.dto.OrderDto;
import com.example.secondresttest.service.OrderService;
import com.example.secondresttest.web.OrderController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @MockBean
    OrderService service;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void saveOrder() throws Exception {
        // Given
        OrderDto order = OrderDto.builder()
                .title("phone")
                .description("new phone for you")
                .build();

        Mockito.when(service.save(order)).thenReturn(order);
        String json = mapper.writeValueAsString(order);

        // When & Then
        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.title", is(order.getTitle())))
                .andExpect(jsonPath("$.description", is(order.getDescription())));
    }
}



