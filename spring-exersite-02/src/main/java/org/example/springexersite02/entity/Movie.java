package org.example.springexersite02.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    int id;
    String name;
    String genre;
    String director;
    int duration;
    String description;
    String publishedDate;
    String category;
}
