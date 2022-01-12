package br.dev.diego.dsmovie.services;

import br.dev.diego.dsmovie.dto.MovieDto;
import br.dev.diego.dsmovie.dto.MovieInsertDto;
import br.dev.diego.dsmovie.dto.MovieUpdateDto;
import br.dev.diego.dsmovie.entities.Movie;
import br.dev.diego.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

  @Autowired
  private MovieRepository repository;

  @Transactional(readOnly = true)
  public Page<MovieDto> findAll(Pageable pageable) {
    return repository.findAll(pageable).map(MovieDto::new);
  }

  @Transactional(readOnly = true)
  public MovieDto findById(Long id) {
    return new MovieDto(repository.findById(id).get());
  }

  @Transactional
  public MovieDto insert(MovieInsertDto movieInsertDto) {
    Movie movie = new Movie();
    copyDtoToEntity(movieInsertDto, movie);
    movie = repository.save(movie);
    return new MovieDto(movie);
  }

  @Transactional
  public MovieDto update(Long id, MovieUpdateDto movieUpdateDto) {
    Movie movie = repository.getById(id);
    copyDtoToEntity(movieUpdateDto, movie);
    repository.save(movie);
    return new MovieDto(movie);
  }

  @Transactional
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  private void copyDtoToEntity(MovieDto movieDto, Movie movie) {
    movie.setTitle(movieDto.getTitle());
    movie.setImage(movieDto.getImage());
    movie.setCount(movieDto.getCount());
    movie.setScore(movieDto.getScore());
  }
}
