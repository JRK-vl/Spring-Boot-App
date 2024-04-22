package com.SpringBootApp.controller;

import com.SpringBootApp.dto.CommentDTO;
import com.SpringBootApp.entity.Comment;
import com.SpringBootApp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> readAll() {
        return new ResponseEntity<>(commentService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> readById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.readById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody CommentDTO dto) {
        return new ResponseEntity<>(commentService.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Comment> update(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.update(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        commentService.delete(id);
        return HttpStatus.OK;
    }
}
