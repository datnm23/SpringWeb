package org.example.midexam2.model.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse{
    Long id;
    String customerName;
    String phoneNumber;
    String email;
    String orderDetails;
    String status;
    LocalDateTime orderTime;
    LocalDateTime processedTime;
}
