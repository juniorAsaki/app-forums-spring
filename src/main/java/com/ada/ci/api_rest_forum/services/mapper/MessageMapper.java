package com.ada.ci.api_rest_forum.services.mapper;


import com.ada.ci.api_rest_forum.models.Message;
import com.ada.ci.api_rest_forum.services.dto.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {
}
