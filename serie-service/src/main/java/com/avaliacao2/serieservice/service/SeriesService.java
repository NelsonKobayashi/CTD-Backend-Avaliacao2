package com.avaliacao2.serieservice.service;

import com.avaliacao2.serieservice.dto.SeriesDTO;
import com.avaliacao2.serieservice.model.Series;
import com.avaliacao2.serieservice.repository.ISeasonsRepository;
import com.avaliacao2.serieservice.repository.ISeriesRepository;
import com.avaliacao2.serieservice.repository.IChaptersRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SeriesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ISeriesRepository seriesRepository;

    @Autowired
    private ISeasonsRepository seasonsRepository;

    @Autowired
    private IChaptersRepository chaptersRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SeriesDTO> listarSeriesPorGenero(String genre) {
        List<Series> series = seriesRepository.findAllByGenreContains(genre);
        return series.stream().map(serie -> modelMapper.map(serie, SeriesDTO.class)).collect(Collectors.toList());
    }

    public void adicionarSerie(SeriesDTO seriesDTO) {
        log.info(restTemplate.getForObject("http://serie-service:8085/series/", String.class));
        Series seriesModel = modelMapper.map(seriesDTO, Series.class);
        seriesModel.getSeasons().forEach(season -> seasonsRepository.save(season));
        seriesRepository.save(seriesModel);
    }


}
