package com.avaliacao2.serieservice.controller;

import com.avaliacao2.serieservice.config.RabbitMQSenderConfig;
import com.avaliacao2.serieservice.dto.SeriesDTO;
import com.avaliacao2.serieservice.service.SeriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    @GetMapping("/{genre}")
    public List<SeriesDTO> listarSeriesPorGenero(@PathVariable(value = "genre") String genre) {
        return seriesService.listarSeriesPorGenero(genre);
    }

    @PostMapping
    public ResponseEntity<?> adicionarSerie(@RequestBody SeriesDTO seriesDTO) {
        seriesService.adicionarSerie(seriesDTO);
        rabbitMQSenderConfig.convertAndSendSeries(seriesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
