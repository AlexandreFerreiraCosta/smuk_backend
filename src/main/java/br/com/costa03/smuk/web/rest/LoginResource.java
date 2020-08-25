package br.com.costa03.smuk.web.rest;

import br.com.costa03.smuk.service.dto.UserListDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class LoginResource {

    @GetMapping("/login")
    public ResponseEntity<String> getLoginTest(){
        log.debug("REST request to get a of Users");
        return new ResponseEntity<>("logado", HttpStatus.OK);
    }
}
