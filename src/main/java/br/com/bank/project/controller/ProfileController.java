package br.com.bank.project.controller;

import br.com.bank.project.dto.ProfileDTO;
import br.com.bank.project.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<ProfileDTO> listAll() {
        return profileService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody ProfileDTO profileDTO) {
        profileService.insert(profileDTO);
    }

    @PutMapping
    public ProfileDTO modify(@RequestBody ProfileDTO profileDTO) {
        return profileService.modify(profileDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable ("id") Long id) {
        profileService.remove(id);
        return ResponseEntity.ok().build();
    }
}
