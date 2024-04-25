package com.SpringBootApp.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String commentText;
    private String author;
}
