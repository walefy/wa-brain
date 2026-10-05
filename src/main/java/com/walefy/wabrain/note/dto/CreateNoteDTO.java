package com.walefy.wabrain.note.dto;

import com.walefy.wabrain.note.NoteEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateNoteDTO {
  @Size(min = 1, max = 255, message = "O titulo deve ter entre 1 e 255 caracteres")
  @NotEmpty(message = "Titulo é obrigatório")
  public String title;

  @Size(min = 1, message = "Conteúdo deve ter no mínimo um caractere")
  @NotBlank(message = "Conteúdo é obrigatório")
  public String content;

  public CreateNoteDTO(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public NoteEntity toEntity() {
    return new NoteEntity(title, content);
  }
}
