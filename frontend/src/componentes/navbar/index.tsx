import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import './styles.css';

function NavBar() {
    return (
        <header>
          <nav className="container">
            <div className="dsmovie-nav-container">
              <h1>DSMovie</h1>
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

export default NavBar;