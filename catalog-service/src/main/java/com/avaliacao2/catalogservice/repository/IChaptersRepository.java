package com.avaliacao2.catalogservice.repository;

import com.avaliacao2.catalogservice.model.Chapters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChaptersRepository extends MongoRepository<Chapters, String> {

}
