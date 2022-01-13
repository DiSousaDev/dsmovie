package br.dev.diego.dsmovie.services;

import br.dev.diego.dsmovie.dto.UserDto;
import br.dev.diego.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  @Transactional
  public UserDto findByEmail(String email) {
    return new UserDto(repository.findByEmail(email));
  }

}
