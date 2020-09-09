package br.com.costa03.smuk.service.impl;

import br.com.costa03.smuk.domain.User;
import br.com.costa03.smuk.repository.UserRepository;
import br.com.costa03.smuk.security.CheckSecurity;
import br.com.costa03.smuk.security.UserSecurity;
import br.com.costa03.smuk.service.UserService;
import br.com.costa03.smuk.service.dto.UserDTO;
import br.com.costa03.smuk.service.dto.UserListDTO;
import br.com.costa03.smuk.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    private UserSecurity userSecurity;

    @Override
    @CheckSecurity.User.PermissionI
    public UserListDTO saveUser(UserDTO user) {
        EncryptPasswordUsers(user);
        User userEncrypt = userMapper.toEntity(user);
        return userMapper.toListDtoUnic(userRepository.save(userEncrypt));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<UserListDTO> findAllUsers() {
        return userMapper.toListDto(userRepository.findAll());
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Optional<UserListDTO> findUser(Long id) {
        //TODO METODO PARA VALIDAR USUÁRIO LOGADO NO CONTEXTO
        System.out.println(userSecurity.getUsuarioId());
        return userRepository.findById(id).map(userMapper::toListDtoUnic);
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
