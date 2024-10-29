package com.ada.ci.api_rest_forum.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ForumDTO {

    private Long idForum;

    private String title;

    private String description;

    private Instant createdDate;

    private String slug;
}
