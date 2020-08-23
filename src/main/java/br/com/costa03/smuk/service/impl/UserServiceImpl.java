package br.com.costa03.smuk.service.impl;

import br.com.costa03.smuk.domain.User;
import br.com.costa03.smuk.repository.UserRepository;
import br.com.costa03.smuk.service.UserService;
import br.com.costa03.smuk.service.dto.UserDTO;
import br.com.costa03.smuk.service.dto.UserListDTO;
import br.com.costa03.smuk.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserListDTO> findAllUsers() {
        return userMapper.toListDto(userRepository.findAll());
    }

    @Override
    public UserListDTO saveUser(UserDTO user) {
        EncryptPasswordUsers(user);
        User userEncrypt = userMapper.toEntity(user);
        return userMapper.toListDtoUnic(userRepository.save(userEncrypt));
    }

    public void EncryptPasswordUsers(UserDTO user){
        String salGerado = BCrypt.gensalt();
        user.setPassword(BCrypt.hashpw(user.getPassword(), salGerado));
    }

    public boolean DecryptPasswordUsers(){
        User user = userRepository.getOne(3L);
        return BCrypt.checkpw("123", user.getPassword());
    }
}
