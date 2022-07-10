package com.avaliacao2.serieservice.repository;

import com.avaliacao2.serieservice.model.Chapters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChaptersRepository extends MongoRepository<Chapters, String> {

}
