package com.avaliacao2.movieservice.controller;

import com.avaliacao2.movieservice.dto.MovieDTO;
import com.avaliacao2.movieservice.config.RabbitMQSenderConfig;
import com.avaliacao2.movieservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    @PostMapping
    public ResponseEntity<?> adicionarMovie(@RequestBody MovieDTO movieDTO) {
        movieService.adicionarMovie(movieDTO);
        rabbitMQSenderConfig.convertAndSendMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
