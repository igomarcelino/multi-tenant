package com.example.multitenant.controller;

import com.example.multitenant.context.TenantContext;
import com.example.multitenant.dto.FiscalDocumentDTO;
import com.example.multitenant.mapper.FiscalDocumentMapper;
import com.example.multitenant.model.FiscalDocument;
import com.example.multitenant.service.FiscalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FiscalDocumentController {

    @Autowired
    FiscalDocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestBody FiscalDocumentDTO dto,
                                             @RequestHeader("X-Tenant-CNPJ") String cnpj) {
        String tenant = TenantContext.getCurrentTenant();
        documentService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Arquivo XML salvo com sucesso no banco de dados do cliente: " + TenantContext.getCurrentTenant());
    }

    @GetMapping("/doc/{cnpjCliente}")
    public ResponseEntity<List<FiscalDocumentDTO>> getDoc(@PathVariable String cnpjCliente,
                                                       @RequestHeader("X-Tenant-CNPJ") String cnpj){
        var documentoCliente =  documentService.findDoc(cnpjCliente);

        return ResponseEntity.ok(documentoCliente);
    }
}