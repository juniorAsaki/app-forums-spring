package com.ada.ci.api_rest_forum.services.Impl;


import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.repositories.ForumRepository;
import com.ada.ci.api_rest_forum.services.ForumService;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import com.ada.ci.api_rest_forum.services.mapper.ForumMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;


    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Request to save Forum : {}", forumDTO);
        Forum forum = forumMapper.DtoToEntity(forumDTO);
        forum = forumRepository.save(forum);
        return forumMapper.ToDto(forum);
    }

    @Override
    public List<ForumDTO> findAll() {
        log.debug("Request to get all Forums");
        return forumRepository.findAll().stream()
                .map(forumMapper::ToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ForumDTO> findOne(Long id) {
        log.debug("Request to get Forum : {}", id);
        return forumRepository.findById(id)
                .map(forumMapper::ToDto);
    }

}
