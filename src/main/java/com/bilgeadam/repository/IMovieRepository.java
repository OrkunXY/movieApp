package com.bilgeadam.repository;

import com.bilgeadam.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByRatingGreaterThan(Double rating);

    List<Movie> findByPremieredBefore(LocalDate premiered);

}
