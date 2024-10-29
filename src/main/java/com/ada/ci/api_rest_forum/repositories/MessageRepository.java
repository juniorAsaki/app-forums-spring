package com.ada.ci.api_rest_forum.repositories;

import com.ada.ci.api_rest_forum.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySubject_IdSubject(Long id);
}
