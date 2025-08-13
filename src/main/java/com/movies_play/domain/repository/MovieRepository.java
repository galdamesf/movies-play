package com.movies_play.domain.repository;

import com.movies_play.domain.dto.MovieDto;
import com.movies_play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    MovieDto delete(long id);
}
