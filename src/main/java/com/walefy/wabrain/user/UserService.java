package com.walefy.wabrain.user;

import com.walefy.wabrain.user.dto.CreateUserDTO;
import com.walefy.wabrain.user.dto.GetUsersQueryDTO;
import com.walefy.wabrain.user.dto.ReturnUserDTO;
import com.walefy.wabrain.user.exception.UserAlreadyExistsException;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {
  @Inject private UserRepository userRepository;

  @Transactional
  public ReturnUserDTO createUser(CreateUserDTO createUserData) {
    var existingUser = userRepository.findByUsername(createUserData.username);

    if (existingUser.isPresent()) {
      throw new UserAlreadyExistsException();
    }

    UserEntity user = createUserData.toEntity();
    user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
    userRepository.persist(user);

    return ReturnUserDTO.fromEntity(user);
  }

  public List<ReturnUserDTO> getUsers(GetUsersQueryDTO query) {
    PanacheQuery<UserEntity> usersQuery;

    if (query.firstName != null && !query.firstName.isBlank()) {
      usersQuery = userRepository.find("firstName ilike ?1", "%" + query.firstName + "%");
    } else {
      usersQuery = userRepository.findAll();
    }

    return usersQuery.page(query.getPanachePage(), query.pageSize).stream()
        .map(ReturnUserDTO::fromEntity)
        .toList();
  }
}
