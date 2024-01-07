package com.example.secondresttest.test;

import com.example.secondresttest.entity.Order;
import com.example.secondresttest.service.OrderService;
import com.example.secondresttest.web.OrderController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setName("Test order");
        order.setDescription("This is a test order.");

        Order savedOrder = new Order();
        savedOrder.setId(1);
        savedOrder.setName(order.getName());
        savedOrder.setDescription(order.getDescription());

        Mockito.when(orderService.save(order)).thenReturn(savedOrder);

        OrderController orderController = new OrderController(orderService);
        Order result = orderController.createOrder(order).getBody();

        assertEquals(savedOrder, result);
        Mockito.verify(orderService).save(order);
    }
}
