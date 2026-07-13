package br.com.bank.project.dto;

import br.com.bank.project.entity.RecurseEntity;
import org.springframework.beans.BeanUtils;

public class RecurseDTO {

    private Long id;
    private String name;
    private String key;

    public RecurseDTO(RecurseEntity recurseEntity) {
        BeanUtils.copyProperties(recurseEntity, this);
    }

    public RecurseDTO() {
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

}
