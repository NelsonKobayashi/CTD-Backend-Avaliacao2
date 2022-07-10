package com.avaliacao2.catalogservice.service;

import com.avaliacao2.catalogservice.dto.MoviesDTO;
import com.avaliacao2.catalogservice.dto.SeriesDTO;
import com.avaliacao2.catalogservice.model.Movies;
import com.avaliacao2.catalog.service.repository.*;
import com.avaliacao2.catalogservice.repository.feing.ISeriesFeing;
import com.avaliacao2.catalogservice.model.Series;
import com.avaliacao2.catalogservice.repository.*;
import com.jardelsilva.catalog.service.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {

    @Autowired
    private IChaptersRepository chaptersRepository;

    @Autowired
    private IGenresRepository genresRepository;

    @Autowired
    private IMoviesRepository moviesRepository;

    @Autowired
    private ISeasonsRepository seasonsRepository;

    @Autowired
    private ISeriesRepository seriesRepository;

    @Autowired
    private ISeriesFeing seriesFeing;

    @Autowired
    private ModelMapper modelMapper;

    public void adicionarSerie(SeriesDTO seriesDTO) {
        Series seriesModel = modelMapper.map(seriesDTO, Series.class);
        seriesRepository.save(seriesModel);
    }

    public void adicionarMovie(MoviesDTO moviesDTO) {
        Movies moviesModel = modelMapper.map(moviesDTO, Movies.class);
        moviesRepository.save(moviesModel);
    }

    public List<SeriesDTO> listarSeriesPorGenero(String genre) {
        return seriesFeing.getSeriesByGenre(genre);
    }

    public List<MoviesDTO> listarMoviesPorGenero(String genre) {
        return moviesRepository.findAllByGenreContains(genre);
    }



}
