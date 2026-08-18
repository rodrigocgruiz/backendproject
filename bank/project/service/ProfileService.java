package br.com.bank.project.service;

import br.com.bank.project.dto.ProfileDTO;
import br.com.bank.project.entity.ProfileEntity;
import br.com.bank.project.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileDTO> listAll(){
        List<ProfileEntity> profileEntities = profileRepository.findAll();
        return profileEntities.stream().map(ProfileDTO::new).toList();
    }

    public void insert(ProfileDTO profileDTO){
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    public ProfileDTO modify(ProfileDTO profileDTO){
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(profileRepository.save(profileEntity));
    }

    public void remove(Long id){
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.deleteById(id);
    }

    public ProfileDTO searchById(Long id){
        return new ProfileDTO(profileRepository.findById(id).get());
    }
}
