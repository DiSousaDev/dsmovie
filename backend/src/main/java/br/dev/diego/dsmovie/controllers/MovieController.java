package br.dev.diego.dsmovie.controllers;

import br.dev.diego.dsmovie.dto.MovieDto;
import br.dev.diego.dsmovie.dto.MovieInsertDto;
import br.dev.diego.dsmovie.dto.MovieUpdateDto;
import br.dev.diego.dsmovie.services.MovieService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

  @Autowired
  private MovieService service;

  @GetMapping
  public ResponseEntity<Page<MovieDto>> findAll(Pageable pageable) {
    return ResponseEntity.ok().body(service.findAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<MovieDto> insert(@RequestBody MovieInsertDto movieInsertDto) {
    MovieDto movie = service.insert(movieInsertDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(movie.getId()).toUri();
    return ResponseEntity.created(uri).body(movie);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MovieDto> insert(@PathVariable Long id, @RequestBody MovieUpdateDto movieUpdateDto) {
    MovieDto movieDto = service.update(id, movieUpdateDto);
    return ResponseEntity.ok().body(movieDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }


}
