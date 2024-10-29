package com.ada.ci.api_rest_forum.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column(name = "content" , nullable = false)
    private String content;

    @Column(name = "createdDate")
    private Instant createdDate;

    @ManyToOne
    private Subject subject;

    @Column(unique = true)
    private String slug;
}
