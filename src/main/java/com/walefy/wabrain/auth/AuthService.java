package com.walefy.wabrain.auth;

import com.walefy.wabrain.auth.dto.JwtResponseDTO;
import com.walefy.wabrain.auth.dto.LoginDTO;
import com.walefy.wabrain.auth.exception.LoginUnauthorized;
import com.walefy.wabrain.user.UserEntity;
import com.walefy.wabrain.user.UserRepository;
import com.walefy.wabrain.user.exception.UserNotFound;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.Optional;

@ApplicationScoped
public class AuthService {
  @Inject UserRepository userRepository;

  public JwtResponseDTO login(@Valid LoginDTO loginDTO) {
    Optional<UserEntity> userOptional = userRepository.findByUsername(loginDTO.username);

    if (userOptional.isEmpty()) {
      throw new UserNotFound();
    }

    UserEntity user = userOptional.get();

    if (!BcryptUtil.matches(loginDTO.password, user.getPassword())) {
      throw new LoginUnauthorized();
    }

    int fifteenMinusInSeconds = 900;

    String token =
        Jwt.claims()
            .issuer("wabrain")
            .subject(loginDTO.username)
            .expiresIn(fifteenMinusInSeconds)
            .sign();

    return new JwtResponseDTO(token);
  }
}
