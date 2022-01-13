package br.dev.diego.dsmovie.dto;

import br.dev.diego.dsmovie.entities.User;

public class UserDto {

  private Long id;
  private String email;

  public UserDto() {
  }

  public UserDto(Long id, String email) {
    this.id = id;
    this.email = email;
  }

  public UserDto(User entity) {
    id = entity.getId();
    email = entity.getEmail();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
