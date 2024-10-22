package org.example.midexam2.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name ="name",nullable = false)
    String name;

    @Column(name ="price",nullable = false)
    Double price;

    @Column(name ="description",length = 1000)
    String description;

    @Column(name ="image_url",nullable = false)
    String imageUrl;
}
