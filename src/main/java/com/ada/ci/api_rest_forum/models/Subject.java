package com.ada.ci.api_rest_forum.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Entity
@Setter
@Table(name = "sujet")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;

    @Column(name = "title" , nullable = false)
    private String title;

    private String description;

    @ManyToOne
    private Forum forum;

    @OneToMany
    private List<Message> message;

    @Column(unique = true)
    private String slug;
}
