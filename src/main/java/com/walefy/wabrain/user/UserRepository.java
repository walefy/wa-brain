package com.walefy.wabrain.user;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<UserEntity, UUID> {
  public Optional<UserEntity> findByFirstName(String firstName) {
    return find("firstName", firstName).firstResultOptional();
  }

  public Optional<UserEntity> findByUsername(String username) {
    return find("username", username).firstResultOptional();
  }
}
