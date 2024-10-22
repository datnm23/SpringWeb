package org.example.midexam2.model.request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {
    @NotNull(message = "ID không được để trống")
    Long id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 255, message = "Tên sản phẩm không được quá 255 ký tự")
    String name;

    @Positive(message = "Giá sản phẩm phải lớn hơn 0")
    Double price;

    @Size(max = 1000, message = "Mô tả không được quá 1000 ký tự")
    String description;

    @NotBlank(message = "URL hình ảnh không được để trống")
    String imageUrl;
}
