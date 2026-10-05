package com.walefy.wabrain.note;

import com.walefy.wabrain.shared.BaseEntity;
import com.walefy.wabrain.user.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "note")
public class NoteEntity extends BaseEntity {
  private String title;
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  public NoteEntity(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}
