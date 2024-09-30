package org.example.springexersite02.repository;

import org.example.springexersite02.entity.Movie;
import org.example.springexersite02.util.file.FileUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class MovieRepository {
    final FileUtil<Movie> fileUtil = new FileUtil<>();
    final String fileName = "db/movie.json";

    public List<Movie> getListMovie() {
        try {
            return fileUtil.readDataFromFile(fileName, Movie[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
