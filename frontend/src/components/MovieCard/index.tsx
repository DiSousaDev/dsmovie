import MovieScore from "components/MovieScore";
import { Link } from "react-router-dom";

function MovieCard() {
  const movie = {
    id: 1,
    image:
      "https://adrenaline.com.br/uploads/2020/09/24/66129/spiderman-2.jpg",
    title: "Spider-Man",
    count: 2,
    score: 4.5,
  };

  return (
    <div>
      <img
        className="dsmovie-movie-card-image"
        src={movie.image}
        alt={movie.title}
      />
      <div className="dsmovie-card-bottom-container">
        <h3>{movie.title}</h3>
        <MovieScore />

        <Link to={`/form/${movie.id}`}>
            <div className="btn btn-primary dsmovie-btn">Avaliar</div>
        </Link>
      </div>
    </div>
  );
}

export default MovieCard;