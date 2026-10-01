package com.walefy.wabrain.user.dto;

import com.walefy.wabrain.shared.dto.PaginateDto;
import jakarta.ws.rs.QueryParam;

public class GetUsersQueryDTO extends PaginateDto {
  @QueryParam("name")
  public String firstName;
}
