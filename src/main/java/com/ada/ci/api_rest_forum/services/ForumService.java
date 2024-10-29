package com.ada.ci.api_rest_forum.services;

import com.ada.ci.api_rest_forum.services.dto.ForumDTO;

import java.util.List;
import java.util.Optional;

public interface ForumService {

    ForumDTO save(ForumDTO forumDTO);

    List<ForumDTO> findAll();

    Optional<ForumDTO> findOne(Long id);

}


