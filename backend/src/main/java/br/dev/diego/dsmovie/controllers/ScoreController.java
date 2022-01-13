package br.dev.diego.dsmovie.controllers;

import br.dev.diego.dsmovie.dto.MovieDto;
import br.dev.diego.dsmovie.dto.ScoreDto;
import br.dev.diego.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

  @Autowired
  private ScoreService scoreService;

  @PutMapping
  public ResponseEntity<MovieDto> saveScore(@RequestBody ScoreDto scoreDto) {
    MovieDto movieDto = scoreService.saveScore(scoreDto);
    return ResponseEntity.ok().body(movieDto);
  }

}
