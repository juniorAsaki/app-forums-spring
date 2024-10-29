package com.ada.ci.api_rest_forum.services.mapper;

import com.ada.ci.api_rest_forum.models.Subject;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SubjectMapper extends EntityMapper<SubjectDTO, Subject>{
}
