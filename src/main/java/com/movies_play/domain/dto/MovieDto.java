package com.movies_play.domain.dto;

import com.movies_play.domain.Genre;
import java.time.LocalDate;


public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        String state
) {
}
