package com.bilgeadam.service;

import com.bilgeadam.entity.Movie;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie, Integer> {

    private final IMovieRepository movieRepository;


    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return movieRepository.saveAll(t);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public Movie delete(Integer integer) {
        return null;
    }


    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        List<Movie>movieList=movieRepository.findAll();
                if(movieList.isEmpty()){
                    throw new NotFoundException("Liste bos");
                }

        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        Optional<Movie> optionalMovie=movieRepository.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NotFoundException("boyle bir film yok");
        }
        return optionalMovie;
    }
    public List<Movie> findByRatingGreaterThan(Double rating){
        return movieRepository.findByRatingGreaterThan(rating);
    }

    public List<Movie> findByPremieredBefore(LocalDate premiered){
        return movieRepository.findByPremieredBefore(premiered);
    }









}
