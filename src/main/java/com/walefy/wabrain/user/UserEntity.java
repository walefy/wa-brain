package com.walefy.wabrain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id @Generated private UUID id;

  @Column(name = "first_name", length = 20)
  private String firstName;

  @Column(name = "birth_date", columnDefinition = "date")
  private Date birthDate;

  @Column(name = "username", length = 20, unique = true)
  private String username;

  private String password;

  public UserEntity(String username, String firstName, Date birthDate, String password) {
    this.firstName = firstName;
    this.birthDate = birthDate;
    this.password = password;
    this.username = username;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
