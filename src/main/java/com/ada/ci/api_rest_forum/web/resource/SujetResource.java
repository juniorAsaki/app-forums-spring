package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.ForumService;
import com.ada.ci.api_rest_forum.services.SubjectService;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;
import com.ada.ci.api_rest_forum.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sujets")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class SujetResource {

    private final SubjectService sujetService;
    private final ForumService forumService;

    @PostMapping
    public ResponseEntity<SubjectDTO> saveSubject(@RequestBody SubjectDTO sujetDTO) {
        log.debug("REST request to save Sujet : {}", sujetDTO);

        Optional<ForumDTO> forumDTO = forumService.findOne(sujetDTO.getForum().getIdForum());

        if(forumDTO.isPresent()) {
            sujetDTO.setForum(forumDTO.get());
            sujetDTO.setSlug(SlugGifyUtils.genereSlug(sujetDTO.getTitle()));
        }

        return new ResponseEntity<>(sujetService.save(sujetDTO) , HttpStatus.CREATED);
    }

    @GetMapping("/forum/{id}")
    public ResponseEntity<List<SubjectDTO>> getAllSujets(@PathVariable Long id) {
        log.debug("REST request to get Sujet : {}", id);
        return new ResponseEntity<>(sujetService.findAllByForum(id) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSujets() {
        log.debug("REST request to get Sujets");
        return new ResponseEntity<>(sujetService.findAll() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> getOneSujet(@PathVariable Long id) {
        log.debug("REST request to get Sujet : {}", id);

        return new ResponseEntity<>(sujetService.getOne(id).get(), HttpStatus.OK);
    }
}
