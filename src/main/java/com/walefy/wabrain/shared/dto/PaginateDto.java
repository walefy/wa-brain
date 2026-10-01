package com.walefy.wabrain.shared.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class PaginateDto {
  @QueryParam("page")
  @DefaultValue("1")
  @Min(value = 1, message = "Página não pode ser menor que 1")
  public Integer page;

  @QueryParam("pageSize")
  @DefaultValue("10")
  @Min(value = 10, message = "Tamanho da página não pode ser menor que 10")
  @Max(value = 100, message = "Tamanho da página não poder ser maior que 100")
  public Integer pageSize;

  /// Retorna a página no formato zero-based para o panache
  public Integer getPanachePage() {
    return this.page - 1;
  }
}
