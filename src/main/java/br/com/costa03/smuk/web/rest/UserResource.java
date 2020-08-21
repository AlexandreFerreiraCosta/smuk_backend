package br.com.costa03.smuk.web.rest;

import br.com.costa03.smuk.domain.User;
import br.com.costa03.smuk.service.UserService;
import br.com.costa03.smuk.service.dto.UserListDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserResource {
    private final Logger log = LoggerFactory.getLogger(User.class);
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserListDTO>> getAllUsers(){
        log.debug("REST request to get a of Users");
        return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUsers(){
        log.debug("REST request to save a of Users");
        User user = new User();
        user.setFullname("Maria Olinda Junior");
        user.setCnpj("2222222222222");
        user.setPassword("123");
        user.setUsername("Maria");
        user.setEnabled(new Boolean("true"));
        user.setType("admin");

        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
    }
}
