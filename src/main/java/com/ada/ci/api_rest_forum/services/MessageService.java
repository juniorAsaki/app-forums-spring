package com.ada.ci.api_rest_forum.services;

import com.ada.ci.api_rest_forum.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    MessageDTO save(MessageDTO messageDTO);
    List<MessageDTO> findAllByIdSujet(Long id);
    List<MessageDTO> findAll();
}
