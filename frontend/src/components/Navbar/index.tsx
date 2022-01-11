import { ReactComponent as GithubIcon } from "assets/img/github.svg";
import { Link } from "react-router-dom";
import "./styles.css";

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="dsmovie-nav-container">
          <Link to="/">
            <h1>DSGame</h1>
          </Link>
          <a href="https://github.com/DiSousaDev">
            <div className="dsmovie-contact-container">
              <GithubIcon />
              <p className="dsmovie-contact-link">/DiSousaDev</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
