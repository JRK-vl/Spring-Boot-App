package com.SpringBootApp.service;

import com.SpringBootApp.dto.CommentDTO;
import com.SpringBootApp.entity.Comment;
import com.SpringBootApp.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment create(CommentDTO dto){
        Comment comment = Comment.builder()
                .commentText(dto.getCommentText())
                .author(dto.getAuthor())
                .build();
        return  commentRepository.save(comment);
    }

    public List<Comment> readAll(){
        return commentRepository.findAll();
    }

    public Comment readById(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public Comment update(Comment comment){
        return commentRepository.save(comment);
    }

    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
