package org.example.midexam2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.midexam2.entity.Order;
import org.example.midexam2.model.response.OrderResponse;
import org.example.midexam2.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    ObjectMapper objectMapper;

    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> objectMapper.convertValue(order, OrderResponse.class)).toList();
    }

}
