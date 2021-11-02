package com.example.demo.controller;

import com.example.demo.domain.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieRepository movieRepository;
    MovieController(MovieRepository movieRepository) { this.movieRepository = movieRepository;}

    @GetMapping("/")
    List<Movie> findAll(){
        return movieRepository.findAll();
    }

    @PostMapping("/")
    Movie save(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @GetMapping("/{id}")
    Movie findById(@PathVariable UUID id){
        return movieRepository.findById(id).orElse(null);
    }

    @GetMapping("/findByTitle")
    Movie findByTitle(@RequestParam String title){
        return movieRepository.findByTitle(title);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id){
        movieRepository.deleteById(id);
    }
}
