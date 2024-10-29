package com.ada.ci.api_rest_forum.services.dto;

import com.ada.ci.api_rest_forum.models.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDTO {

    private Long idSubject;

    private String title;

    private String description;

    private ForumDTO forum;

    private String slug;
}
