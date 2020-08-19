package br.com.costa03.smuk.service.mapper;

import br.com.costa03.smuk.domain.User;
import br.com.costa03.smuk.service.dto.UserListDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
    List<UserListDTO> toListDto(List<User> entity);
}
