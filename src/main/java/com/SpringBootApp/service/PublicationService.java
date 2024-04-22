package com.SpringBootApp.service;

import com.SpringBootApp.dto.PublicationDTO;
import com.SpringBootApp.entity.Publication;
import com.SpringBootApp.repository.PublicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {
    private PublicationRepository publicationRepository;

    public Publication create(PublicationDTO dto){
        Publication publication = Publication.builder()
                .title(dto.getTitle())
                .postText(dto.getPostText())
                .author(dto.getAuthor())
                .build();
        return publicationRepository.save(publication);
    }
    public List<Publication> readAll(){
        return publicationRepository.findAll();
    }

    public Publication readById(Long id){
        return publicationRepository.findById(id).orElse(null);
    }

    public Publication update(Publication publication){
        return publicationRepository.save(publication);
    }

    public void delete(Long id){
        publicationRepository.deleteById(id);
    }
}
