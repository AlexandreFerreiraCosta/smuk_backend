package br.com.costa03.smuk.service;

import br.com.costa03.smuk.domain.User;
import br.com.costa03.smuk.service.dto.UserDTO;
import br.com.costa03.smuk.service.dto.UserListDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserListDTO> findAllUsers();
    UserListDTO saveUser(UserDTO user);
    Optional<UserListDTO> findUser(Long id);
}
