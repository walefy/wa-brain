package com.walefy.wabrain.user;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity extends PanacheEntityBase {
  @Id @Generated private UUID id;

  @Column(name = "first_name", length = 20)
  private String firstName;

  @Column(name = "birth_date", columnDefinition = "date")
  private Date birthDate;

  private String password;

  public UserEntity(String firstName, Date birthDate, String password) {
    this.firstName = firstName;
    this.birthDate = birthDate;
    this.password = password;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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
