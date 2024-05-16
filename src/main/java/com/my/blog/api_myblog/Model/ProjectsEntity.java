package com.my.blog.api_myblog.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity @Table(name = "projects_entity")
public class ProjectsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "language")
    private String language;

    @Column(name = "framework")
    private String framework;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;
}
