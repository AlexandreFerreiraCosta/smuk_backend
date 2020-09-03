package br.com.costa03.smuk.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_group", schema = "public")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_group")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_group")
    @SequenceGenerator(name = "sq_group", sequenceName = "sq_group", allocationSize = 1)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "rl_group_permission", joinColumns = @JoinColumn(name = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "id_permission"))
    private Set<Permission> permission = new HashSet<>();
}
