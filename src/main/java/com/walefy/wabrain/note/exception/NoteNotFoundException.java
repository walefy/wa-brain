package com.walefy.wabrain.note.exception;

import com.walefy.wabrain.shared.exception.HttpException;
import org.jboss.resteasy.reactive.RestResponse;

public class NoteNotFoundException extends HttpException {
  public NoteNotFoundException() {
    super("Nota não encontrada", RestResponse.Status.NOT_FOUND);
  }
}
