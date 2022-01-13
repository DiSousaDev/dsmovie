package br.dev.diego.dsmovie.repositories;

import br.dev.diego.dsmovie.entities.Score;
import br.dev.diego.dsmovie.entities.pk.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
