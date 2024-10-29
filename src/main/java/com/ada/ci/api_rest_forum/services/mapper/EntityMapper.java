package com.ada.ci.api_rest_forum.services.mapper;

public interface EntityMapper <D,E> {

    D ToDto(E entity);
    E DtoToEntity(D dto);
}
