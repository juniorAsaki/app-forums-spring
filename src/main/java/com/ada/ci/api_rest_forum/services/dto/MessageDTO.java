package com.ada.ci.api_rest_forum.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MessageDTO {


    private Long idMessage;

    private String content;

    private Instant createdDate;

    private SubjectDTO subject;

    private String slug;
}
