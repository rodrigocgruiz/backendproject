package br.com.bank.project.controller;

import br.com.bank.project.dto.RecurseDTO;
import br.com.bank.project.service.RecurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/recurse")
@CrossOrigin
public class RecurseController {
    @Autowired
    private RecurseService recurseService;

    @GetMapping
    public List<RecurseDTO> listAll() {
        return recurseService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody RecurseDTO recurseDTO) {
        recurseService.insert(recurseDTO);
    }

    @PutMapping
    public RecurseDTO modify(@RequestBody RecurseDTO recurseDTO) {
        return recurseService.modify(recurseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> remove(@PathVariable ("id") Long id) {
        recurseService.remove(id);
        return ResponseEntity.ok().build();
    }
}
