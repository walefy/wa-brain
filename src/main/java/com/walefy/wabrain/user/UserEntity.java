package com.walefy.wabrain.user;

import com.walefy.wabrain.shared.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

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
