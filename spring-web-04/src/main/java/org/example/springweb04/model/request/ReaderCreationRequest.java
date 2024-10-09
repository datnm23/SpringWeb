package org.example.springweb04.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderCreationRequest {

    int id;
    String name;
    String email;
    String phone;
    String address;

}
