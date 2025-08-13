package com.movies_play.web.controller;

import com.movies_play.domain.dto.MovieDto;
import com.movies_play.domain.dto.SuggestRequestDto;
import com.movies_play.domain.dto.UpdateMovieDto;
import com.movies_play.domain.service.MovieService;
import com.movies_play.domain.service.MoviesPlayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operations about movies of MoviesPlay")
public class MovieController {
    private final MovieService movieService;
    private final MoviesPlayService aiService;

    public MovieController(MovieService movieService, MoviesPlayService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by id",
            description = "Returns the movie that matches the sent identifier",
            responses = {
                    @ApiResponse(responseCode = "200", description = "movie found"),
                    @ApiResponse(responseCode = "404", description = "movie not found", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "identifier of the movie to be recovered", example = "9") @PathVariable Long id) {
        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto){
        return ResponseEntity.ok(this.aiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id ,@RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable long id) {
        return ResponseEntity.ok(this.movieService.delete(id));
    }
}
