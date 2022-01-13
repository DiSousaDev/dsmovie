package br.dev.diego.dsmovie.services;

import br.dev.diego.dsmovie.dto.MovieDto;
import br.dev.diego.dsmovie.dto.ScoreDto;

import br.dev.diego.dsmovie.entities.Movie;
import br.dev.diego.dsmovie.entities.Score;
import br.dev.diego.dsmovie.entities.User;
import br.dev.diego.dsmovie.repositories.MovieRepository;
import br.dev.diego.dsmovie.repositories.ScoreRepository;
import br.dev.diego.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

  @Autowired
  private ScoreRepository scoreRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Transactional
  public MovieDto saveScore(ScoreDto scoreDto) {

    User user = userRepository.findByEmail(scoreDto.getEmail());

    if(user == null) {
      user = new User();
      user.setEmail(scoreDto.getEmail());
      user = userRepository.saveAndFlush(user);
    }

    Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();

    Score score = new Score(user, movie, scoreDto.getScore());

    scoreRepository.saveAndFlush(score);

    double sum = 0.0;
    for(Score s : movie.getScores()) {
      sum += s.getValue();
    }
    int size = movie.getScores().size();
    double avg = sum / size;

    movie.setScore(avg);
    movie.setCount(size);

    movie = movieRepository.saveAndFlush(movie);

    return new MovieDto(movie);
  }

}
