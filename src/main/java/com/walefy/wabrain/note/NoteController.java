package com.walefy.wabrain.note;

import com.walefy.wabrain.note.dto.CreateNoteDTO;
import com.walefy.wabrain.note.dto.ReturnNoteDTO;
import com.walefy.wabrain.shared.dto.PaginateDto;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;
import java.util.UUID;

@Authenticated
@Path("/note")
public class NoteController {
  @Inject private NoteService noteService;
  @Inject private JsonWebToken jwt;

  @POST
  public ReturnNoteDTO createNote(@Valid CreateNoteDTO createNoteData) {
    String username = jwt.getSubject();
    return noteService.createNote(createNoteData, username);
  }

  @GET
  public List<ReturnNoteDTO> getNotes(PaginateDto paginateDto) {
    String username = jwt.getSubject();
    return noteService.getNotes(paginateDto, username);
  }

  @GET
  @Path("/{id}")
  public ReturnNoteDTO getNote(@PathParam("id") UUID noteId) {
    String username = jwt.getSubject();
    return noteService.getNote(noteId, username);
  }

  @DELETE
  @Path("/{id}")
  public void deleteNote(@PathParam("id") UUID noteId) {
    String username = jwt.getSubject();
    noteService.deleteNote(noteId, username);
  }
}
