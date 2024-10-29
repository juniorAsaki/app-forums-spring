package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.ForumService;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import com.ada.ci.api_rest_forum.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/forums")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ForumResource {

    private final ForumService forumService;

    @PostMapping
    public ResponseEntity<ForumDTO> createForum(@RequestBody ForumDTO forumDTO) throws URISyntaxException {
        log.debug("request to create forum: {}", forumDTO);

        if (forumDTO.getIdForum() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        forumDTO.setCreatedDate(Instant.now());
        forumDTO.setSlug(SlugGifyUtils.genereSlug(forumDTO.getTitle()));
        ForumDTO forumSave = forumService.save(forumDTO);
        return ResponseEntity.created(new URI("/api/forums/" + forumSave.getIdForum())).body(forumSave);
    }


    @GetMapping
    public ResponseEntity<List<ForumDTO>> getAllForums() {
        log.debug("request to get all forums");
        List<ForumDTO> forums = forumService.findAll();
       return ResponseEntity.ok().body(forums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumDTO> getOneForum(@PathVariable Long id) {
        log.debug("request to get forum: {}", id);
        Optional<ForumDTO> forumDTO = forumService.findOne(id);
        return forumDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
