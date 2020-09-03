package br.com.costa03.smuk.service.dto;

import br.com.costa03.smuk.domain.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String fullname;

    private String username;

    private Boolean enabled;

    private String cnpj;

    private String type;

    private Set<Group> groups = new HashSet<>();
}
