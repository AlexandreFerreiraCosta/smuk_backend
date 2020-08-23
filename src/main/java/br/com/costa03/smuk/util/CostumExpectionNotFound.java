package br.com.costa03.smuk.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CostumExpectionNotFound extends RuntimeException{

    public CostumExpectionNotFound(String mensagem){
        super(mensagem);
    }
}
