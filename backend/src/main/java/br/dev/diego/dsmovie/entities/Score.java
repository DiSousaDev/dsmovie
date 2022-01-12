package br.dev.diego.dsmovie.entities;

import br.dev.diego.dsmovie.entities.pk.ScorePK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

  @EmbeddedId
  private ScorePK id = new ScorePK();

  private Double value;

  public Score() {
  }

  public Score(User user, Movie movie, Double value) {
    id.setUser(user);
    id.setMovie(movie);
    this.value = value;
  }

  public User getUser() {
    return id.getUser();
  }

  public void setUser(User user) {
    id.setUser(user);
  }

  public Movie getMovie() {
    return id.getMovie();
  }

  public  void setMovie(Movie movie) {
    id.setMovie(movie);
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
