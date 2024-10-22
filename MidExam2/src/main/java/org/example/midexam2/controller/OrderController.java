package org.example.midexam2.controller;

import lombok.AllArgsConstructor;
import org.example.midexam2.model.response.OrderResponse;
import org.example.midexam2.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class OrderController {

    OrderService orderService;

    @GetMapping
    public String getOrders(Model model) {
        List<OrderResponse> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "admin/orders";
    }

}
