package com.my.blog.api_myblog.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "type_project")
    private String typeProject;

    @Column(name = "link_project")
    private String linkProject;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;
}
