package com.ada.ci.api_rest_forum.repositories;

import com.ada.ci.api_rest_forum.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {
}
