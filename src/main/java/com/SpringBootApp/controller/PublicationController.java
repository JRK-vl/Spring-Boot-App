package com.SpringBootApp.controller;

import com.SpringBootApp.entity.Publication;
import com.SpringBootApp.service.PublicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
@AllArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;

    @GetMapping
    public ResponseEntity<List<Publication>> readAll() {
        return new ResponseEntity<>(publicationService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> readById(@PathVariable Long id) {
        return new ResponseEntity<>(publicationService.readById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Publication> update(@RequestBody Publication publication) {
        return new ResponseEntity<>(publicationService.update(publication), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        publicationService.delete(id);
        return HttpStatus.OK;
    }
}
