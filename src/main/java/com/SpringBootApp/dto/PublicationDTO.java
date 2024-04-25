package com.SpringBootApp.dto;

import lombok.Data;

@Data
public class PublicationDTO {
    private Long id;
    private String title;
    private String postText;
    private String author;
}
