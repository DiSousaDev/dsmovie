package br.dev.diego.dsmovie.entities.pk;

import br.dev.diego.dsmovie.entities.Movie;
import br.dev.diego.dsmovie.entities.User;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScorePK implements Serializable {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  public ScorePK() {
  }

  public ScorePK(User user, Movie movie) {
    this.user = user;
    this.movie = movie;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

}
