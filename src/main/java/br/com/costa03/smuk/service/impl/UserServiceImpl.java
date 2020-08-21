package br.com.costa03.smuk.service.impl;

import br.com.costa03.smuk.domain.User;
import br.com.costa03.smuk.repository.UserRepository;
import br.com.costa03.smuk.service.UserService;
import br.com.costa03.smuk.service.dto.UserListDTO;
import br.com.costa03.smuk.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Logger log = LoggerFactory.getLogger(User.class);

    @Override
    public List<UserListDTO> findAllUsers() {
        return userMapper.toListDto(userRepository.findAll());
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(EncryptPasswordUsers(user));
        return userRepository.save(user);
    }

    public String EncryptPasswordUsers(User user){
        String salGerado = BCrypt.gensalt();
        System.out.println("Validando senha: "+DecryptPasswordUsers());
        return BCrypt.hashpw(user.getPassword(), salGerado);
    }

    public boolean DecryptPasswordUsers(){
        User user = userRepository.getOne(3L);

        return BCrypt.checkpw("113", user.getPassword());
    }
}
