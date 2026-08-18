package br.com.bank.project.entity;

import br.com.bank.project.dto.RecurseDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "PRJ_Recurse")
public class RecurseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String key;


    public RecurseEntity(RecurseDTO recurseDTO) {
        BeanUtils.copyProperties(recurseDTO, this);
    }

    public RecurseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null )
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecurseEntity other = (RecurseEntity) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
