package com.ada.ci.api_rest_forum.services.Impl;

import com.ada.ci.api_rest_forum.repositories.MessageRepository;
import com.ada.ci.api_rest_forum.services.MessageService;
import com.ada.ci.api_rest_forum.services.dto.MessageDTO;
import com.ada.ci.api_rest_forum.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        log.debug("Save message : {}", messageDTO);
        return messageMapper.ToDto(messageRepository.save(messageMapper.DtoToEntity(messageDTO)));
    }

    @Override
    public List<MessageDTO> findAllByIdSujet(Long id) {
        log.debug("findAllByIdSubject : {}", id);
        return messageRepository.findBySubject_IdSubject(id).stream().map(messageMapper::ToDto).toList();
    }

    @Override
    public List<MessageDTO> findAll() {
        log.debug("findAll : ");
        return messageRepository.findAll().stream().map(messageMapper::ToDto).toList();
    }
}
