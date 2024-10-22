package org.example.midexam2.model.request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderUpdateRequest {
    @NotNull(message = "ID không được để trống")
    Long id;

    @NotBlank(message = "Tên khách hàng không được để trống")
    @Size(max = 255, message = "Tên khách hàng không được quá 255 ký tự")
    String customerName;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0[3|5|7|8|9])+([0-9]{8})$", message = "Số điện thoại không hợp lệ")
    String phoneNumber;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Size(max = 150, message = "Email không được quá 150 ký tự")
    String email;

    @NotBlank(message = "Chi tiết đơn hàng không được để trống")
    @Size(max = 1000, message = "Chi tiết đơn hàng không được quá 1000 ký tự")
    String orderDetails;
}
