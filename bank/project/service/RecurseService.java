package br.com.bank.project.service;

import br.com.bank.project.dto.RecurseDTO;
import br.com.bank.project.entity.RecurseEntity;
import br.com.bank.project.repository.RecurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecurseService {
    @Autowired
    private RecurseRepository recurseRepository;

    public List<RecurseDTO> listAll() {
        List<RecurseEntity> recurseEntities = recurseRepository.findAll();
        return recurseEntities.stream().map(RecurseDTO::new).toList();
    }

    public void insert(RecurseDTO recurseDTO) {
        RecurseEntity recurseEntity = new RecurseEntity(recurseDTO);
        recurseRepository.save(recurseEntity);
    }

    public RecurseDTO modify(RecurseDTO recurseDTO) {
        RecurseEntity recurseEntity = new RecurseEntity(recurseDTO);
        return new RecurseDTO(recurseRepository.save(recurseEntity));
    }

    public void remove(Long id) {
        RecurseEntity recurseEntity = recurseRepository.findById(id).get();
        recurseRepository.deleteById(id);
    }

    public RecurseDTO searchById(Long id) {
        return new RecurseDTO(recurseRepository.findById(id).get());
    }
}
