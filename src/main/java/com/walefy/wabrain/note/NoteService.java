package com.walefy.wabrain.note;

import com.walefy.wabrain.note.dto.CreateNoteDTO;
import com.walefy.wabrain.note.dto.ReturnNoteDTO;
import com.walefy.wabrain.note.exception.NoteNotFoundException;
import com.walefy.wabrain.shared.dto.PaginateDto;
import com.walefy.wabrain.user.UserEntity;
import com.walefy.wabrain.user.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class NoteService {
  @Inject private NoteRepository noteRepository;
  @Inject private UserService userService;

  @Transactional
  public ReturnNoteDTO createNote(CreateNoteDTO createNoteData, String username) {
    UserEntity user = userService.getUserByUsername(username);

    NoteEntity note = createNoteData.toEntity();
    note.setUser(user);
    noteRepository.persist(note);

    return new ReturnNoteDTO(note);
  }

  public List<ReturnNoteDTO> getNotes(PaginateDto paginateDto, String username) {
    UserEntity user = userService.getUserByUsername(username);

    return noteRepository
        .find("userId", user.getId())
        .page(paginateDto.page, paginateDto.pageSize)
        .stream()
        .map(ReturnNoteDTO::new)
        .toList();
  }

  public ReturnNoteDTO getNote(UUID noteId, String username) {
    NoteEntity note = this.getNoteById(noteId, username);
    return new ReturnNoteDTO(note);
  }

  public void deleteNote(UUID noteId, String username) {
    NoteEntity note = this.getNoteById(noteId, username);
    noteRepository.delete(note);
  }

  public NoteEntity getNoteById(UUID noteId, String username) throws NoteNotFoundException {
    UserEntity user = userService.getUserByUsername(username);
    Optional<NoteEntity> noteOption = noteRepository.findByIdOptional(noteId);

    if (noteOption.isEmpty()) throw new NoteNotFoundException();

    NoteEntity note = noteOption.get();
    UUID noteUserId = note.getUser().getId();
    if (!noteUserId.equals(user.getId())) throw new NoteNotFoundException();

    return note;
  }
}
