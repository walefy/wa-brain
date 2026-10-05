package com.walefy.wabrain.note.dto;

import com.walefy.wabrain.note.NoteEntity;

import java.util.UUID;

public class ReturnNoteDTO {
  public UUID id;
  public String title;
  public String content;
  public UUID userId;

  public ReturnNoteDTO(NoteEntity note) {
    this.id = note.getId();
    this.title = note.getTitle();
    this.content = note.getContent();
  }
}
