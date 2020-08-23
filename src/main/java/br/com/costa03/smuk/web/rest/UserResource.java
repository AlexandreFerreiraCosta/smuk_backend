package br.com.costa03.smuk.web.rest;

import br.com.costa03.smuk.service.UserService;
import br.com.costa03.smuk.service.dto.UserDTO;
import br.com.costa03.smuk.service.dto.UserListDTO;
import br.com.costa03.smuk.util.HeaderUtil;
import br.com.costa03.smuk.util.ResponseUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class UserResource {
    private final UserService userService;
    private final HeaderUtil headerUtil = new HeaderUtil();
    private static final String ENTITY_NAME = "user";

    @PostMapping("/users")
    public ResponseEntity<UserListDTO> createEditUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);

        UserListDTO result = userService.saveUser(userDTO);

        return ResponseEntity.created(new URI("/api/users"))
                .headers(headerUtil.createEntityCreationAlert(ENTITY_NAME, result.getFullname()))
                .body(result);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserListDTO>> getAllUsers(){
        log.debug("REST request to get a of Users");
        return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserListDTO> getUser(@PathVariable Long id){
        return ResponseUtil.wrapOrNotFound(userService.findUser(id));
    }
}
