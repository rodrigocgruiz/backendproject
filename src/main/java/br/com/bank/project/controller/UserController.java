package br.com.bank.project.controller;

import br.com.bank.project.dto.UserDTO;
import br.com.bank.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping
    public List<UserDTO> listAll() {
        return userService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody UserDTO userDTO) {
        userService.insert(userDTO);
    }

    @PutMapping
    public UserDTO modify(@RequestBody UserDTO userDTO) {
        return  userService.modify(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id){
        userService.remove(id);
        return ResponseEntity.ok().build();
    }
}
