package com.ada.ci.api_rest_forum.services;

import com.ada.ci.api_rest_forum.models.Subject;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    SubjectDTO save(SubjectDTO sujetDTO);
    List<SubjectDTO> findAllByForum(Long id);
    Optional<SubjectDTO> getOne(Long id);
    List<SubjectDTO> findAll();

}
