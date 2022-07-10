package com.avaliacao2.movieservice.services;

import com.avaliacao2.movieservice.dto.MovieDTO;
import com.avaliacao2.movieservice.model.Movie;
import com.avaliacao2.movieservice.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IMovieRepository movieRepository;

    public void adicionarMovie(MovieDTO movieDTO) {
        Movie movieModel = modelMapper.map(movieDTO, Movie.class);
        movieRepository.save(movieModel);
    }

}
