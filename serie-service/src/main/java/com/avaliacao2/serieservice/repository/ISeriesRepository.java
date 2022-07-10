package com.avaliacao2.serieservice.repository;

import com.avaliacao2.serieservice.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends MongoRepository<Series, String> {

    List<Series> findAllByGenreContains(String genre);

}
