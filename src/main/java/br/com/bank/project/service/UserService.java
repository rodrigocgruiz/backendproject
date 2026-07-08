package br.com.bank.project.service;

import br.com.bank.project.dto.UserDTO;
import br.com.bank.project.entity.UserEntity;
import br.com.bank.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> listAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserDTO::new).toList();
    }

    public void insert(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO modify(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        return new UserDTO(userRepository.save(userEntity));
    }

    public void remove(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }

    public UserDTO searchById(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }

}
