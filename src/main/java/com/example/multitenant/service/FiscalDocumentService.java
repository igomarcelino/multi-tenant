package com.example.multitenant.service;

import com.example.multitenant.dto.FiscalDocumentDTO;
import com.example.multitenant.mapper.FiscalDocumentMapper;
import com.example.multitenant.model.FiscalDocument;
import com.example.multitenant.repository.FiscalDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiscalDocumentService {

    @Autowired
    private FiscalDocumentRepository fiscalDocumentRepository;

    @Autowired
    private FiscalDocumentMapper fiscalDocumentMapper;

    public FiscalDocumentDTO save(FiscalDocumentDTO documentDTO){

        FiscalDocument fiscalDocument = fiscalDocumentMapper.toEntity(documentDTO);
        fiscalDocument.setContent(documentDTO.getContent());
        fiscalDocument.setCnpj(documentDTO.getCnpj());
        fiscalDocumentRepository.save(fiscalDocument);

        return fiscalDocumentMapper.toDTO(fiscalDocument);
    }

    public List<FiscalDocumentDTO> findDoc(String cnpjCliente) {

        var documentoLocalizado = fiscalDocumentRepository.findByCnpj(cnpjCliente);


        return documentoLocalizado.
                stream().
                map(fiscalDocument -> fiscalDocumentMapper.toDTO(fiscalDocument)).
                collect(Collectors.toList());
    }
}
