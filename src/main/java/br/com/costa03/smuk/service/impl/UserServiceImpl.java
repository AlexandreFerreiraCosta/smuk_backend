package br.com.costa03.smuk.service.impl;

import br.com.costa03.smuk.repository.UserRepository;
import br.com.costa03.smuk.service.UserService;
import br.com.costa03.smuk.service.dto.UserListDTO;
import br.com.costa03.smuk.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserListDTO> findAllUsers() {
        return userMapper.toListDto(userRepository.findAll());
    }
}
