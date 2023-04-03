package com.bilgeadam.controller;

import com.bilgeadam.entity.Movie;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MovieController {

private final MovieService movieService;

@PostMapping("/save")
public ResponseEntity<Movie>save(@RequestBody Movie movie){
    return ResponseEntity.ok(movieService.save(movie));
}
@GetMapping("/find-all")
public ResponseEntity<List<Movie>>findAll(){
    return ResponseEntity.ok(movieService.findAll());
}
@GetMapping("/find-by-id/{id}")
public ResponseEntity<Optional<Movie>>findById(@PathVariable Integer id){
    return ResponseEntity.ok(movieService.findById(id));
}
@GetMapping("/find-by-rating-greater-than/{rating}")
public ResponseEntity<List<Movie>> findByRatingGreaterThan(@PathVariable  double rating){
    return ResponseEntity.ok(movieService.findByRatingGreaterThan(rating));
}
@GetMapping("/find-by-premiered-before")
public ResponseEntity<List<Movie>> findByPremiereBefore(String date){
    return ResponseEntity.ok(movieService.findByPremieredBefore((LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")))));
}

}
