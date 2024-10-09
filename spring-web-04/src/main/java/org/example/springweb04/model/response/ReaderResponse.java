package org.example.springweb04.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderResponse {

    int id;
    String name;
    String email;
    String phone;
    String address;

}
