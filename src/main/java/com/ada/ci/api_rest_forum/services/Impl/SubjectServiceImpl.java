package com.ada.ci.api_rest_forum.services.Impl;

import com.ada.ci.api_rest_forum.models.Subject;
import com.ada.ci.api_rest_forum.repositories.SubjectRepository;
import com.ada.ci.api_rest_forum.services.SubjectService;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;
import com.ada.ci.api_rest_forum.services.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository sujetRepository;

    private final SubjectMapper sujetMapper;


    @Override
    public SubjectDTO save(SubjectDTO sujetDTO) {
        log.debug("Request to save Sujet : {}", sujetDTO);
        return sujetMapper.ToDto(sujetRepository.save(sujetMapper.DtoToEntity(sujetDTO)));
    }

    @Override
    public List<SubjectDTO> findAllByForum(Long id) {
        log.debug("Request to get all Sujets by Forum : {}", id);
        return sujetRepository.findAllByForum_IdForum(id).stream().map(sujetMapper::ToDto).toList();
    }

    @Override
    public Optional<SubjectDTO> getOne(Long id) {
        log.debug("Request to get Sujet : {}", id);
        return sujetRepository.findById(id).map(sujetMapper::ToDto);
    }

    @Override
    public List<SubjectDTO> findAll() {
        return sujetRepository.findAll().stream().map(sujetMapper::ToDto).toList();
    }


}
