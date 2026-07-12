package br.com.bank.project.dto;

import br.com.bank.project.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String email;
    private String password;

    public UserDTO(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
