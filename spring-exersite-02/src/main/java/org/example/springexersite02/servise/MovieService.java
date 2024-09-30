package org.example.springexersite02.servise;

import org.example.springexersite02.entity.Movie;
import org.example.springexersite02.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public List<Movie> getMovies() {
        return movieRepository.getListMovie();
    }
}
