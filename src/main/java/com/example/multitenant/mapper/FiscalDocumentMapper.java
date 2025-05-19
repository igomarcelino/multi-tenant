package com.example.multitenant.mapper;

import com.example.multitenant.dto.FiscalDocumentDTO;
import com.example.multitenant.model.FiscalDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FiscalDocumentMapper {

    @Mapping(target = "id", ignore = true)
    FiscalDocument toEntity(FiscalDocumentDTO dto);
    FiscalDocumentDTO toDTO(FiscalDocument entity);


}
