package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.MessageService;
import com.ada.ci.api_rest_forum.services.SubjectService;
import com.ada.ci.api_rest_forum.services.dto.MessageDTO;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;
import com.ada.ci.api_rest_forum.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class MessageResource {

    private final MessageService messageService;
    private final SubjectService sujetService;

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody MessageDTO messageDTO) {
        log.debug("REST request to save Message : {}", messageDTO);

        Optional<SubjectDTO> sujet = sujetService.getOne(messageDTO.getSubject().getIdSubject());

        if (sujet.isPresent()) {
            messageDTO.setSubject(sujet.get());
            messageDTO.setCreatedDate(Instant.now());
            messageDTO.setSlug(SlugGifyUtils.genereSlug(messageDTO.getContent().substring(0,8)));

            return new ResponseEntity<>(messageService.save(messageDTO) , HttpStatus.CREATED);
        }
        return new ResponseEntity<>("subject not found" , HttpStatus.NOT_FOUND);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<List<MessageDTO>> getAllMessagesByIdSubject(@PathVariable Long id) {
        log.debug("REST request to get all Messages");
        return new ResponseEntity<>(messageService.findAllByIdSujet(id) , HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        log.debug("REST request to get all Messages");
        return new ResponseEntity<>(messageService.findAll() , HttpStatus.OK);
    }
}
