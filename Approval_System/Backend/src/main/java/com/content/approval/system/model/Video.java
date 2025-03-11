package com.content.approval.system.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String originalVideoUrl; 
    private String editedVideoUrl; 
    private boolean isApproved;
    private String ownerComments;
}
