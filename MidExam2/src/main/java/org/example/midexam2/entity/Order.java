package org.example.midexam2.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name ="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name ="customer_name",nullable = false)
    String customerName;

    @Column(name ="phone",nullable = false, length = 10)
    String phoneNumber;

    @Column(name ="email",nullable = false)
    String email;

    @Column(name ="order_detail",nullable = false, length = 1000)
    String orderDetails;

    @Column(name ="status", nullable = false)
    OrderStatus status;

    @Column(name ="order_time",nullable = false)
    LocalDateTime orderTime;

    @Column(name = "processed_time",nullable = false)
    LocalDateTime processedTime;


    public enum OrderStatus {
        PENDING, CONFIRMED, CANCELLED
    }
}
