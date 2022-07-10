package com.avaliacao2.catalogservice.repository;

import com.avaliacao2.catalogservice.dto.MoviesDTO;
import com.avaliacao2.catalogservice.model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends MongoRepository<Movies, String> {

    List<MoviesDTO> findAllByGenreContains(String genre);

}
