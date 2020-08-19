package br.com.costa03.smuk.service;

import br.com.costa03.smuk.service.dto.UserListDTO;

import java.util.List;

public interface UserService {
    List<UserListDTO> findAllUsers();
}
